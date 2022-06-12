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

            Intent(this, CvicenieScreen::class.java).also {
                startActivity(it)
            }

            /*Intent(this, Quotes::class.java).also {
                startActivity(it)
            }*/
            finish()
        }

    }


}


// Sources
/*
    XML
    round button - https://www.geeksforgeeks.org/how-to-change-background-image-by-button-clicking-event-in-android/
    navigation - https://www.youtube.com/watch?v=DI0NIk-7cz8

    CODE
    list https://www.youtube.com/watch?v=KPvYXXERLjk
    recycler view - https://www.youtube.com/watch?v=-PIKVIJb7Xs
    activity X fragment - https://www.geeksforgeeks.org/difference-between-a-fragment-and-an-activity-in-android/
    screen rotaion in manifest - https://www.youtube.com/watch?v=pRg3f0sdHf8
    data binding - https://www.youtube.com/watch?v=as28MREKz4c&t=337s
    prechod medzi snimkami - https://www.youtube.com/watch?v=UWqoz5Kln4k
*/


// Problems
/*
    https://stackoverflow.com/questions/69030567/aapt-error-failed-writing-to-path-to-android-project-app-build-intermediates
*/

//odporuca sa viewBinding lebo kotlin extensions uz nie su vyvojarmi podporovane (kvazi aich mozeme pouzivat ale ......)