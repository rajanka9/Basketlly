package com.example.basketlly


import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


// https://stackoverflow.com/questions/39962816/get-random-images-in-android-studio
// https://www.youtube.com/playlist?list=PLQkwcJG4YTCTq1raTb5iMuxnEB06J1VHX
// ctrl + q --> ukaze dokumentaciu

class Quotes: AppCompatActivity() {
//public class Quotes extends Fragment {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quotes_screen)
        val buttonNewQuote: Button = findViewById(R.id.button_quotes)

        buttonNewQuote.setOnClickListener {
            /*val toast = Toast.makeText(this, "Here is a new quote!", Toast.LENGTH_SHORT)
            toast.show()*/
            randomQuote()
            randomBackground()
            }
    }

    fun randomQuote(){
        // vrati nahodny vyrok
        val vyroky = arrayOf(R.string.quote1, R.string.quote2, R.string.quote3, R.string.quote4, R.string.quote5, R.string.quote6, R.string.quote7, R.string.quote8, R.string.quote9,
            R.string.quote10, R.string.quote11, R.string.quote12, R.string.quote13, R.string.quote14, R.string.quote15, R.string.quote16, R.string.quote17, R.string.quote18, R.string.quote19,
            R.string.quote20, R.string.quote21, R.string.quote22, R.string.quote23, R.string.quote24, R.string.quote25, R.string.quote26, R.string.quote27, R.string.quote28, R.string.quote29)
        val quotesGenerator = Generator(29)
        val quoteCislo = quotesGenerator.generuj()
        val vyrok = vyroky[quoteCislo]
        //najdenie idcka
        val vyrokTextovaPodoba: TextView = findViewById(R.id.quote_text)
        //nastavenie idcka
        vyrokTextovaPodoba.setText(vyrok)

    }

    fun randomBackground(){
        // vrati nahodne pozadie
        val backrounds = arrayOf(R.drawable.background_1, R.drawable.background_2, R.drawable.background_3, R.drawable.background_4, R.drawable.background_5, R.drawable.background_6, R.drawable.background_7)
        val pozadieGenerator = Generator(7)
        val quotePozadie = pozadieGenerator.generuj()
        val pozadie = backrounds[quotePozadie]
        //najdenie idcka
        findViewById<ConstraintLayout>(R.id.quotes_screen).setBackgroundResource(pozadie)
        //nastavenie idcka
    }
}

//generator nahodnych cisel
class Generator(private val pocet: Int) {
    fun generuj(): Int {
        return (1..pocet).random()
    }
}