package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var rollButton: Button
    private lateinit var imageView: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView = findViewById(R.id.resultTextView)
        imageView = findViewById(R.id.imageView)
        rollButton = findViewById(R.id.rollButton)


        rollButton.setOnClickListener{
            rollDice()
        }
    }

    private fun rollDice()
    {
        val random = Random()
        val randomNumber = random.nextInt(6)+1
        val resultText = "You rolled a $randomNumber"

        resultTextView.text = resultText

        val drawableResource = when (randomNumber) {
            1 -> R.drawable.dice_one
            2 -> R.drawable.dice_two
            3 -> R.drawable.dice_three
            4 -> R.drawable.dice_four
            5 -> R.drawable.dice_five
            else -> R.drawable.dice_six
        }
        imageView.setImageResource(drawableResource)

    }
}