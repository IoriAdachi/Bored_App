package com.example.boredapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Process.killProcess
import android.view.View
import android.widget.Toast
import com.example.boredapp.Deep.DeepFry
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_settings.*
import android.os.Process
import android.os.Process.myPid

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainintent = getIntent()
        val developermode=mainintent.getBooleanExtra("ischecked",false)
        if(developermode)
        {button_main_selfdestruct.setVisibility(View.VISIBLE)}
        else
        {button_main_selfdestruct.setVisibility(View.INVISIBLE)}

        button_main_color.setOnClickListener {
            val colorGuessIntent = Intent(this@MainActivity, ColorGuess::class.java)
            startActivity(colorGuessIntent)
        }

        button_main_deepfry.setOnClickListener {
            val deepFryIntent = Intent(this@MainActivity, DeepFry::class.java)
            startActivity(deepFryIntent)
        }

        button_main_numbers.setOnClickListener {
            val numberFactsIntent = Intent(this@MainActivity, NumberFacts::class.java)
            startActivity(numberFactsIntent)
        }

        button_main_settings.setOnClickListener {
            val settingsIntent = Intent(this@MainActivity, Settings::class.java)
            settingsIntent.putExtra("savechecked", developermode)
            startActivity(settingsIntent)

        }

        button_main_selfdestruct.setOnClickListener{
            finishAffinity()
        }



    }
}