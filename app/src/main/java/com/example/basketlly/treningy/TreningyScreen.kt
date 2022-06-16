package com.example.basketlly.treningy

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basketlly.TreningAdapter
import com.example.basketlly.data.DataCvicenie
import com.example.basketlly.data.DataTrening
import com.example.basketlly.databinding.TreningyScreenBinding
import com.example.basketlly.trening.TreningScreen

// Trieda TreningyScreen nam nacita data z predchadzajucej aktivity a pomocou recyclerView nam ich zobrazi

class TreningyScreen: AppCompatActivity() {

    private lateinit var binding: TreningyScreenBinding
    var treningyList = mutableListOf<DataTrening>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TreningyScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = TreningyAdapter(treningyList)
        val recyclerPohladov = binding.recyclerViewTraining
        recyclerPohladov.adapter = adapter
        recyclerPohladov.layoutManager = LinearLayoutManager(this)

        treningyList.add(DataTrening("xxxxxxxxx", "30.2.2000", "3x3"))
        treningyList.add(DataTrening("xxxxxxxxx", "30.2.2000", "6"))
        treningyList.add(DataTrening("xxxxxxxxx", "30.2.2000", "7"))

        val nazovTren = intent.getStringExtra("EXTRA_TRENINGNAZOV").toString()
            val datumTren = intent.getStringExtra("EXTRA_TRENINGDATUM").toString()
                val loptaTren = intent.getStringExtra("EXTRA_TRENINGLOPTA").toString()
        val dataTren = DataTrening(nazovTren, datumTren, loptaTren)
        treningyList.add(dataTren)
        adapter.notifyItemInserted(treningyList.size - 1)

        binding.btnNewTraining.setOnClickListener {
            Intent(this, TreningScreen::class.java).also {
            startActivity(it)
            }
            finish()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(ContentValues.TAG, "onSaveInstanceState")

    }



}