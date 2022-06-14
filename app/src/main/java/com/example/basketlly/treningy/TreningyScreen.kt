package com.example.basketlly.treningy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basketlly.data.DataTrening
import com.example.basketlly.databinding.TreningyScreenBinding
import com.example.basketlly.trening.TreningScreen

class TreningyScreen: AppCompatActivity() {

    private lateinit var binding: TreningyScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TreningyScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNewTraining.setOnClickListener { Intent(this, TreningScreen::class.java).also {
            startActivity(it)
        } }

       val treningList = mutableListOf(
            DataTrening("nazovjdkjs", "29.9.2000", 3),
            DataTrening ("jhjhbjhb", "29.9.2020", 6),
            DataTrening("nazovhbjjdkjs", "20.9.2000", 7),
                    DataTrening("nazovhxcgdfbjjdkjs", "20.11.2000", 7)

        )

        val adapter = TreningyAdapter(treningList)
        val recyclerPohladov = binding.recyclerViewTraining
        recyclerPohladov.adapter = adapter
        recyclerPohladov.layoutManager = LinearLayoutManager(this)

    }

}