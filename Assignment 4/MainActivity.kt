package com.example.groceryapp

import android.content.Intent
import android.content.IntentSender
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.CardDefaults.shape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.groceryapp.ui.theme.GroceryAppTheme
import java.util.concurrent.Flow

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            GroceryAppTheme {
                // A surface container using the 'background' color from the theme
                val description = "Brugers"



                Column{

                    Column(modifier = Modifier.padding(15.dp))
                    {
                        Spacer(modifier = Modifier.height(30.dp))

                        Text(
                            text = "WELCOME BACK",
                            fontWeight = FontWeight.Black,
                            fontSize = 33.sp,
                            color = Color.Black,
                            letterSpacing = 2.sp
                        )
                        Text(
                            text = "ANAADI!",
                            fontWeight = FontWeight.Black,
                            fontSize = 33.sp,
                            color = Color.Black,
                        )
                        Spacer(modifier = Modifier.height(60.dp))
                        Text(text = "What do you want to eat?",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                    }
                    FlowRow(
                        modifier = Modifier.padding(8.dp),
                        Arrangement.Center
                    )
                    {

                        ImageCard(
                            painter = painterResource(id = R.drawable.img),
                            contentDescription = description,
                            title = "Burgers",
                            navigateTo = {
                                val intent = Intent(this@MainActivity, Restaurant::class.java)
                                startActivity(intent)
                            })
                        ImageCard(
                            painter = painterResource(id = R.drawable.pizza),
                            contentDescription = description,
                            title = "Pizzas",
                            navigateTo = {
                                val intent = Intent(this@MainActivity, Restaurant::class.java)
                                startActivity(intent)
                            })
                        ImageCard(
                            painter = painterResource(id = R.drawable.biriyani),
                            contentDescription = description,
                            title = "Biriyani",
                            navigateTo = {
                                val intent = Intent(this@MainActivity, Restaurant::class.java)
                                startActivity(intent)
                            })
                        ImageCard(
                            painter = painterResource(id = R.drawable.naan),
                            contentDescription = description,
                            title = "Amritsari Naan",
                            navigateTo = {
                                val intent = Intent(this@MainActivity, Restaurant::class.java)
                                startActivity(intent)
                            })


                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}



@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier,
    navigateTo: () -> Unit // This is a lambda to handle navigation
)
{


    Card (
        modifier = modifier
            .fillMaxWidth(0.5f)
            .padding(8.dp)
            .height(200.dp),

        shape = RoundedCornerShape(15.dp),
        elevation = cardElevation(5.dp),

    ){
        Box(modifier = Modifier
            .height(200.dp)
            .clickable { navigateTo() })
        {

            Image(    painter = painter?.takeIf { it != null } ?: painterResource(id = R.drawable.img),
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop )

            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                )
            )

            Box(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
                contentAlignment = Alignment.BottomCenter
            )
            {
                Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))

            }
        }
    }
}




@OptIn(ExperimentalLayoutApi::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GroceryAppTheme {
    }
}