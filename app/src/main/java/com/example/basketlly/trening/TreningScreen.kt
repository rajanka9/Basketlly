package com.example.basketlly.trening

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basketlly.R
import com.example.basketlly.TreningAdapter
import com.example.basketlly.cvicenia.CvicenieScreen
import com.example.basketlly.data.DataCvicenie
import com.example.basketlly.treningy.TreningyScreen
import com.example.basketlly.databinding.TreningScreenBinding
import java.util.ArrayList

class TreningScreen: AppCompatActivity() {

    private lateinit var binding: TreningScreenBinding
    var dataList2 = mutableListOf<DataCvicenie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TreningScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val treningNazov = binding.nameExercise.text
        val treningDatum = binding.trainingDate.text
        val treningLopta = when (binding.radioGroupBalls.checkedRadioButtonId) {
            R.id.ball_size_3x3 -> 3
            R.id.ball_size_7 -> 7
            else -> 6
        }

        val adapter = TreningAdapter(dataList2)
        val recyclerPohladov2 = binding.recyclerViewExercises
        recyclerPohladov2.adapter = adapter
        recyclerPohladov2.layoutManager = LinearLayoutManager(this)

        dataList2.add(DataCvicenie("xxxxxxxxx","0", "0", "0"))

        val nazov = intent.getStringExtra("EXTRA_SENDDATA").toString()
        val dane = intent.getStringExtra("EXTRA_SENDDANE").toString()
        val pokusy = intent.getStringExtra("EXTRA_SENDPOKUSY").toString()
        val percento = intent.getStringExtra("EXTRA_SENDPERCENTO").toString()

        if (dane.isNullOrEmpty() || pokusy.isNullOrEmpty() || percento.isNullOrEmpty()){
                val dataCv = DataCvicenie(" ", "0", "0", "0")
        }

        val dataCv = DataCvicenie(nazov, dane, pokusy, percento)
        dataList2.add(dataCv)
        adapter.notifyItemInserted(dataList2.size - 1)

        /*if (dane.isNotBlank() || pokusy.isNotBlank() || percento.isNotBlank()) {
            val dataCv = DataCvicenie(nazov, dane.toInt(), pokusy.toInt(), percento.toInt())
            dataList2.add(dataCv)
            adapter.notifyItemInserted(dataList2.size - 1)
        }*/

        /*val adapter = TreningAdapter(dataList2)
        val recyclerPohladov2 = binding.recyclerViewExercises
        recyclerPohladov2.adapter = adapter
        recyclerPohladov2.layoutManager = LinearLayoutManager(this)*/

        binding.btnNewExercise.setOnClickListener {
            Intent(this, CvicenieScreen::class.java).also { startActivity(it) }
        }

        binding.buttonAddTraining.setOnClickListener {
            Intent(this, TreningyScreen::class.java).also {
                it.putExtra("EXTRA_TRENINGNAZOV", treningNazov)
                it.putExtra("EXTRA_TRENINGDATUM", treningDatum)
                it.putExtra("EXTRA_TRENINGLOPTA", treningLopta)

                startActivity(it)

            }
            finish()


        }



    }

    override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
            Log.i(TAG, "onSaveInstanceState")

        }

    override fun onBackPressed() {
        super.onBackPressed()

    }

}


