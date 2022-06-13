package com.example.basketlly

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basketlly.databinding.TreningScreenBinding


class TreningScreen: AppCompatActivity() {

    private lateinit var binding: TreningScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TreningScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)



        /*val nazov = intent.getStringExtra("EXTRA_SENDNAZOV")
        val dane = intent.getStringExtra("EXTRA_SENDDANE")
        val pokusy = intent.getStringExtra("EXTRA_SENDPOKUSY")*/


    }

}