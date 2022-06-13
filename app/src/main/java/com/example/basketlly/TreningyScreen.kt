package com.example.basketlly

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basketlly.databinding.TreningyScreenBinding

class TreningyScreen: AppCompatActivity() {

    private lateinit var binding: TreningyScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TreningyScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }



}