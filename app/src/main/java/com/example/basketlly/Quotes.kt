package com.example.basketlly


import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

// https://stackoverflow.com/questions/39962816/get-random-images-in-android-studio



class Quotes {

    public fun randomQuote() {
        //val quoteLayout: Layout = fin

        val backrounds = arrayOf(R.drawable.background_1, R.drawable.background_2, R.drawable.background_3, R.drawable.background_4, R.drawable.background_5, R.drawable.background_6, R.drawable.background_7)
        val pozadieGenerator = Generator(7)
        val quotePozadie = pozadieGenerator.generuj()
        val pozadie = backrounds[quotePozadie]
        //val backround: View = find


        val vyroky = arrayOf(R.string.quote1, R.string.quote2, R.string.quote3, R.string.quote4, R.string.quote5, R.string.quote6, R.string.quote7, R.string.quote8, R.string.quote9,
            R.string.quote10, R.string.quote11, R.string.quote12, R.string.quote13, R.string.quote14, R.string.quote15, R.string.quote16, R.string.quote17, R.string.quote18, R.string.quote19,
            R.string.quote20, R.string.quote21, R.string.quote22, R.string.quote23, R.string.quote24, R.string.quote25, R.string.quote26, R.string.quote27, R.string.quote28, R.string.quote29)
        val quotesGenerator = Generator(29)
        val quoteCislo = quotesGenerator.generuj()
        val vyrok = vyroky[quoteCislo]


        //val quoteText: TextView = findViewById(R.id.quote_text)
        //quoteText.setText(vyrok)


        //val screenView: View = findViewById(R.layout.quotes_screen);


    }

    val newQuoteButton: Button = findViewById(R.id.button_quotes)

    newQuoteButton.setOnClickListener {this.randomQuote()}

}

class Generator(private val pocet: Int) {
    fun generuj(): Int {
        return (1..pocet).random()
    }

}