package com.example.boredapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_main_color.setOnClickListener {
            val colorGuessIntent = Intent(this@MainActivity, ColorGuess::class.java)
            startActivity(colorGuessIntent)
            finish()
        }

        button_main_deepfry.setOnClickListener {
            val deepFryIntent = Intent(this@MainActivity, DeepFry::class.java)
            startActivity(deepFryIntent)
            finish()
        }
    }
}