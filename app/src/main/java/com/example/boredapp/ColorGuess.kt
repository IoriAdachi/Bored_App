package com.example.boredapp

import android.graphics.Color
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_color_guess.*


class ColorGuess : AppCompatActivity() {

    companion object{
        val TAG = "Color desu"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_guess)

        randomize()
        textView_color_boxchange.setBackgroundColor(Color.rgb(red_change, green_change, blue_change))

        button_color_confirm.setOnClickListener {
            Toast.makeText(this,check().toString(),Toast.LENGTH_SHORT).show()
        }

        seekBar_color_h.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                hue = progress
                hsltorgb()
                textView_color_boxchange.setBackgroundColor(Color.rgb(red_change, green_change, blue_change))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                hsltorgb()
                textView_color_boxchange.setBackgroundColor(Color.rgb(red_change, green_change, blue_change))
            }
        })

        seekBar_color_s.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                sat = progress
                hsltorgb()
                textView_color_boxchange.setBackgroundColor(Color.rgb(red_change, green_change, blue_change))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //write custom code to on start progress
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                hsltorgb()
                textView_color_boxchange.setBackgroundColor(Color.rgb(red_change, green_change, blue_change))
            }
        })

        seekBar_color_v.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                value = progress
                hsltorgb()
                textView_color_boxchange.setBackgroundColor(Color.rgb(red_change, green_change, blue_change))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                //write custom code to on start progress
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                hsltorgb()
                textView_color_boxchange.setBackgroundColor(Color.rgb(red_change, green_change, blue_change))
            }
        })

    }



    var red: Int = 0
    var green: Int = 0
    var blue: Int = 0

    var red_change: Int = 0
    var green_change: Int = 0
    var blue_change: Int = 0

    var hue: Int = 0
    var sat: Int = 0
    var value: Int = 0




    fun randomize(){
        red = (0..255).random()
        green = (0..255).random()
        blue = (0..255).random()
        textView_color_box.setBackgroundColor(Color.rgb(red, green, blue))
    }


    fun hsltorgb() {
        var huec:Double = hue.toDouble()
        var satc:Double = (sat.toDouble())/100
        var valuec:Double = (value.toDouble())/100

        var c = valuec * satc
        var x = c * (1- Math.abs((huec/60) %2 -1))
        var m = valuec - c

        var r:Double = 0.0
        var g:Double = 0.0
        var b:Double = 0.0

        if(0<=huec&&huec<60){ r=c;g=x;b=0.0 }
        if(60<=huec&&huec<120){ r=x;g=c;b=0.0 }
        if(120<=huec&&huec<180){ r=0.0;g=c;b=x }
        if(180<=huec&&huec<240){ r=0.0;g=x;b=c }
        if(240<=huec&&huec<300){ r=x;g=0.0;b=c }
        if(300<=huec&&huec<360){ r=c;g=0.0;b=x }

        red_change = ((r+m)*255).toInt()
        green_change = ((g+m)*255).toInt()
        blue_change = ((b+m)*255).toInt()
    }

    fun check(): Int{
        var scoreR:Int
        var scoreG:Int
        var scoreB:Int

        scoreR = Math.abs(red - red_change)
        scoreG = Math.abs(green - green_change)
        scoreB = Math.abs(blue - blue_change)

        return ((scoreR + scoreG + scoreB)/3)
    }

}