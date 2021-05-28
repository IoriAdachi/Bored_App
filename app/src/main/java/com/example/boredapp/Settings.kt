package com.example.boredapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_settings.*

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)


        val reintent = getIntent()
        val savemode=reintent.getBooleanExtra("savechecked",false)
        switch_settings_developer.setChecked(savemode)

        //var check:String
        button_settings_back.setOnClickListener {
            val mainintent = Intent(this@Settings,MainActivity::class.java)
            mainintent.putExtra("ischecked", switch_settings_developer.isChecked)
            /*if(switch_settings_developer.isChecked){
                mainintent.putExtra("ischecked","true")
                check = "yes"
            }

            else{
                //intent.putExtra("isChecked","false")
                check = "no"
            }*/
            startActivity(mainintent)
            //Toast.makeText(this, switch_settings_developer.isChecked.toString(), Toast.LENGTH_SHORT).show()
        }
    }


}