package com.example.basketlly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

//testovacie veci
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.quotes_screen)
        val newQuoteButton: Button = findViewById(R.id.button_quotes)

        val q = Quotes()
        newQuoteButton.setOnClickListener {q.randomQuote()}



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