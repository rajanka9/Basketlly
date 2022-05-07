package com.example.basketlly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

//import android.widget.Button

//testovacie veci
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.button_let_me_in)
        button.setOnClickListener(){
            //alt + enter import (ale dako to nejde)
            // mame zamer otvorit dalsiu aktivitu
            Intent(this, Quotes::class.java).also {
                startActivity(it)
            }


        }
    }
}


// Sources
/*
    https://www.geeksforgeeks.org/how-to-change-background-image-by-button-clicking-event-in-android/
*/


// Problems
/*
    https://stackoverflow.com/questions/69030567/aapt-error-failed-writing-to-path-to-android-project-app-build-intermediates
*/