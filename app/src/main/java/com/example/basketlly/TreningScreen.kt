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

    }

}