package com.example.boredapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mashape.unirest.http.Unirest
import kotlinx.android.synthetic.main.activity_number_facts.*
import org.jetbrains.anko.activityUiThread
import org.jetbrains.anko.doAsync
import org.json.JSONObject
import java.lang.Double.parseDouble

class NumberFacts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_facts)

        /*doAsync {

            var aresponse =
                Unirest.get("https://numbersapi.p.rapidapi.com/1729/math?json=true")
                    .header("x-rapidapi-key", "53ce377376msh40774f727bfa42dp1711a8jsn8ba85e776d6e")
                    .header("x-rapidapi-host", "numbersapi.p.rapidapi.com")
                    .asString();
        var all = aresponse.body


            var allres=JSONObject(all).getString("text")
            textView_numbers_facts.text=allres.toString()

            //activityUiThread {
                //textView_numbers_facts.text=allres.toString()
            //}
        } */

        button_numbers_serach.setOnClickListener {
            var numeric = true
            try {
                val num = parseDouble(editText_numbers_input.text.toString())
            } catch (e: NumberFormatException) {
                numeric = false
            }
            if(numeric)
                searchy(editText_numbers_input.text.toString())
            else
                textView_numbers_facts.text="Numbers only"
        }
    }

    fun searchy(number:String){
        doAsync {

            var aresponse =
                Unirest.get("https://numbersapi.p.rapidapi.com/$number/math?json=true")
                    .header("x-rapidapi-key", "53ce377376msh40774f727bfa42dp1711a8jsn8ba85e776d6e")
                    .header("x-rapidapi-host", "numbersapi.p.rapidapi.com")
                    .asString();
            var all = aresponse.body


            var allres=JSONObject(all).getString("text")
            textView_numbers_facts.text=allres.toString()

            //activityUiThread {
            //textView_numbers_facts.text=allres.toString()
            //}
        }
    }
}