package com.example.basketlly

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Adapter
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.basketlly.databinding.CvicenieScreenBinding
import java.text.NumberFormat

//class CvicenieScreenAktivita : Fragment(R.layout.cvicenie_screen){

// https://www.youtube.com/watch?v=hjEE6c0oOI0
class CvicenieScreen: AppCompatActivity() {

    private lateinit var binding: CvicenieScreenBinding
    //private var dataCvicenie:
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = CvicenieScreenBinding.inflate(layoutInflater)
            setContentView(binding.root)
        binding.buttonPercentageExercise.setOnClickListener{ percentoStrelby() }

        //percentoStrelby()

        //binding.buttonAddExercise.setOnClickListener{}
        //finish()
    }

    private fun percentoStrelby() {
        val nazovTextPole = binding.nameExercise.text
        val daneTextPole = binding.numberSuccessfulAttempts.text.toString()
            //binding.numberSuccessfulAttempts.text.toString()
        val pokusyTextPole = binding.numberAllAttempts.text.toString()
            //binding.nameAllAttempts.text.toString()


        var daneHodnota = daneTextPole.toIntOrNull()
        var pokusyHodnota = pokusyTextPole.toIntOrNull()

        if(daneHodnota == null || pokusyHodnota == null || pokusyHodnota == 0) {
            binding.percentageOfExercise.text = ""
            return
        }

        if (daneHodnota == null || pokusyHodnota == null || daneHodnota == 0 )
        {
            displayPercento(0)
            return
        }
        /*val daneHodnota = daneTextPole.toInt()
        val pokusyHodnota = pokusyTextPole.toInt()


        if( daneTextPole == null && pokusyTextPole == null ) {
            binding.percentageOfExercise.text.apply {
                " "
            }
            return
        }*/

        //displayPercento(daneTextPole.toInt(), pokusyTextPole.toInt())
        //if (daneHodnota >= 0 && pokusyHodnota > 0 && daneHodnota < pokusyHodnota  ) {
            //var dataCvicenie = DataCvicenie(nazovTextPole.toString(), daneTextPole, pokusyTextPole)
            //displayPercento(daneTextPole,pokusyTextPole)
        //}

        var percento = (daneHodnota.toDouble() / pokusyHodnota * 100).toInt()
        displayPercento(percento)
    }

    private fun displayPercento(percento: Int) {
        //val formattedPercento = NumberFormat.getCurrencyInstance().format(percento)
        binding.percentageOfExercise.text = getString(R.string.percentage, percento.toString()+"%")

    }

}