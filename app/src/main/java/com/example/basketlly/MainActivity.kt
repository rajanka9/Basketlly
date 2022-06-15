package com.example.basketlly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.basketlly.cvicenia.CvicenieScreen
import com.example.basketlly.trening.TreningScreen
import com.example.basketlly.treningy.TreningyScreen

//import android.widget.Button

//testovacie veci
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.activity_main)

        /*var treningList = mutableListOf(
            DataTrening("nazovjdkjs", "29.9.2000", 3),
            DataTrening ("jhjhbjhb", "29.9.2020", 6),
            DataTrening("nazovhbjjdkjs", "20.9.2000", 7)
        )

        val adapter = TreningyAdapter(treningList)
        val recyclerPohladov = binding.recyclerViewTraining
        recyclerPohladov.adapter = adapter
        recyclerPohladov.layoutManager = LinearLayoutManager(this)*/

        val button : Button = findViewById(R.id.button_training)
        button.setOnClickListener(){
            //alt + enter import (ale dako to nejde)
            // mame zamer otvorit dalsiu aktivitu

            Intent(this, TreningyScreen::class.java).also {
                startActivity(it)
            }

        }

        val button2 : Button = findViewById(R.id.button_quotes)
        button2.setOnClickListener {
            Intent(this, Quotes::class.java).also {
                startActivity(it)
            }

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
                    - https://www.youtube.com/watch?v=HtwDXRWjMcU
                    - https://www.youtube.com/watch?v=HtwDXRWjMcU&list=PLQkwcJG4YTCTq1raTb5iMuxnEB06J1VHX&index=21
    activity X fragment - https://www.geeksforgeeks.org/difference-between-a-fragment-and-an-activity-in-android/
    screen rotaion in manifest - https://www.youtube.com/watch?v=pRg3f0sdHf8
    data binding - https://www.youtube.com/watch?v=as28MREKz4c&t=337s
    prechod medzi snimkami - https://www.youtube.com/watch?v=UWqoz5Kln4k
    passing data between activities - https://www.youtube.com/watch?v=IWXYV1dC2FQ

    database - https://www.youtube.com/watch?v=8YPXv7xKh2w&t=5297s
                - https://www.youtube.com/watch?v=2K_eFam0qBg
                - https://www.youtube.com/watch?v=iTdzBM1zErA


*/
//sdadwa


// Problems
/*
    https://stackoverflow.com/questions/69030567/aapt-error-failed-writing-to-path-to-android-project-app-build-intermediates

 */


//odporuca sa viewBinding lebo kotlin extensions uz nie su vyvojarmi podporovane (kvazi aich mozeme pouzivat ale ......)