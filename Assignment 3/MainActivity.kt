package com.example.linkscomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.linkscomposable.ui.theme.LinksComposableTheme
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.Typography
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.linkscomposable.ECommerceSite
import com.example.linkscomposable.ecommerceSites
import kotlin.collections.mapOf



@Composable
fun Greeting(name: String) {
    Text(text = "Hello, $name!")
}



data class ECommerceSite(val name: String, val url: String)

val ecommerceSites = listOf(
    ECommerceSite("Amazon", "https://www.amazon.com/"),
    ECommerceSite("eBay", "https://www.ebay.com/"),
    ECommerceSite("Walmart", "https://www.walmart.com/"),
)




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LinksComposableTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ECommerceApp()
                }
            }
        }
    }
}



@Composable
fun ECommerceButton(
    site: ECommerceSite,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(text = site.name)
    }
}

val customH4TextStyle = TextStyle(
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 24.sp,
    color = Color.Black
)

@Composable
fun ECommerceList() {
    val context = LocalContext.current
    val navController = rememberNavController()

    BackHandler {
        if (navController.currentBackStackEntry?.destination?.route == "WebPage") {
            navController.popBackStack()
        }
    }

    NavHost(navController, startDestination = "ECommerceList") {
        composable("ECommerceList") {

            LazyColumn {
                item {
                    Text(
                        text = "Links",
                        style = customH4TextStyle.copy(
                            fontSize = 24.sp,
                            color = Color.Red
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                }
                items(ecommerceSites) { site ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = site.name,
                            style = customH4TextStyle,
                            modifier = Modifier.weight(1f)
                        )

                        Image(
                            painter = painterResource(id = getLogoResourceId(site.name)), // Replace with actual image resource ID
                            contentDescription = null,
                            modifier = Modifier
                                .size(150.dp)
                                .padding(8.dp)
                        )

                        Button(
                            onClick = {
                                val intent = Intent(Intent.ACTION_VIEW)
                                intent.data = Uri.parse(site.url)
                                context.startActivity(intent)
                            },
                            modifier = Modifier.padding(start = 16.dp)
                        ) {
                            Text(text = "Visit")
                        }
                    }
                }
            }
        }
    }
}
@DrawableRes

fun getLogoResourceId(siteName: String): Int {
    return when (siteName) {
        "Amazon" -> R.drawable.img
        "eBay" -> R.drawable.img_1
        "Walmart" -> R.drawable.img_2
        else -> R.drawable.img
    }
}


@Composable
fun ECommerceApp() {
    MaterialTheme {
        ECommerceList()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewECommerceApp() {
    ECommerceApp()
}