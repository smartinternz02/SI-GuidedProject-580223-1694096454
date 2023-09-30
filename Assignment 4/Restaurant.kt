package com.example.groceryapp

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceryapp.ui.theme.GroceryAppTheme

class Restaurant : ComponentActivity() {
    @OptIn(ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroceryAppTheme {
                Column{

                    Column(modifier = Modifier.padding(15.dp))
                    {
                        Spacer(modifier = Modifier.height(30.dp))

                        Text(
                            text = "RESTAURANTS",
                            fontWeight = FontWeight.Black,
                            fontSize = 30.sp,
                            color = Color.Black,
                        )
                    }

                    FlowRow(
                        modifier = Modifier
                            .padding(8.dp)
                            .verticalScroll(rememberScrollState()),
                        Arrangement.Center
                    )
                    {
                        RestaurantCard(
                            painter = painterResource(id = R.drawable.burgerking),
                            contentDescription = "-Burger -5$ for one",
                            title = "Burger King",
                            rating = "4.3"
                        )
                        RestaurantCard(
                            painter = painterResource(id = R.drawable.mcdonald),
                            contentDescription = "-Burger -6$ for one",
                            title = "McDonalds",
                            rating = "4.4"
                        )
                        RestaurantCard(
                            painter = painterResource(id = R.drawable.burgesingh),
                            contentDescription = "-Burger -5$ for one",
                            title = "Burger Singh",
                            rating = "4.1"
                        )
                        RestaurantCard(
                            painter = painterResource(id = R.drawable.burgercompany),
                            contentDescription = "-Burger -6$ for one",
                            title = "Burger Company",
                            rating = "4.1"
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun RestaurantCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier,
    rating: String
)
{


    Card (
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(300.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(5.dp),

        ){
        Column(modifier = Modifier
            .background(Color.White)
            .fillMaxSize()){
            Box(modifier = Modifier
                .height(200.dp)
                .clickable {}
                .background(Color.White),
            )
            {

                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
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
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    contentAlignment = Alignment.TopEnd
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.tabler_heart),
                        contentDescription = contentDescription,
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(15.dp),
                Arrangement.SpaceBetween
            )
            {
                Text(text = title, style = TextStyle(color = Color.Black, fontSize = 25.sp, fontWeight = FontWeight.Bold))
                val ratingGreen = Color(0, 102, 0)
                Column(
                    modifier = Modifier
                        .background(ratingGreen, shape = RoundedCornerShape(5.dp))
                        .padding(5.dp),
                ){
                    Text(
                        text = rating,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
            }

            Box(modifier = Modifier
                .padding(horizontal = 15.dp)
                .background(Color.White)){
                Text(
                    text = contentDescription,
                    color = Color.Gray,
                    fontSize = 15.sp,
                )
            }


        }
    }
}
@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    GroceryAppTheme {

    }
}