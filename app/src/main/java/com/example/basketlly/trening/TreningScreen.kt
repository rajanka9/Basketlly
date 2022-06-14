package com.example.basketlly.trening

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basketlly.TreningAdapter
import com.example.basketlly.cvicenia.CvicenieScreen
import com.example.basketlly.data.database.data.DataCvicenie
import com.example.basketlly.data.database.data.DataTrening
import com.example.basketlly.treningy.TreningyScreen
import com.example.basketlly.databinding.TreningScreenBinding
import com.example.basketlly.treningy.TreningyAdapter

class TreningScreen: AppCompatActivity() {

    private lateinit var binding: TreningScreenBinding
    //var dataList = arrayListOf<DataCvicenie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TreningScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cviceniaList = mutableListOf(
            DataCvicenie("nazovjdkjs", 45, 90, 50),
            DataCvicenie("nazovjdkjs", 10, 100, 10),
            DataCvicenie("nazovjdkjs", 50, 100, 50),
            DataCvicenie("nazovjdkjs", 45, 90, 50),
        )

        val adapter = TreningAdapter(cviceniaList)
        val recyclerPohladov2 = binding.recyclerViewExercises
        recyclerPohladov2.adapter = adapter
        recyclerPohladov2.layoutManager = LinearLayoutManager(this)

        binding.btnNewExercise.setOnClickListener{
            Intent (this, CvicenieScreen::class.java).also { startActivity(it) }

        }

        binding.buttonAddTraining.setOnClickListener{
            Intent (this, TreningyScreen::class.java).also { startActivity(it) }

            finish()
        }

        //val recyclerView=binding.recyclerViewExercises

       // val dataJednoCviko = intent.getSerializableExtra("EXTRA_DATAJEDNOCVIKO") as DataCvicenie

        //val data = arrayListOf<DataCvicenie>()
        //dataList.add(DataCvicenie(dataJednoCviko.nazov, dataJednoCviko.dane, dataJednoCviko.pokusy))

        //val adapter = CvicenieAdapter(this, dataList)

        //data.add(DataCvicenie("cesta okolo sveta", 25, 50))
        //data.add(DataCvicenie("cesta okolo sveta2", 25, 100))

        //recyclerView.adapter = adapter
        //recyclerView.layoutManager = LinearLayoutManager(this)

    }

}