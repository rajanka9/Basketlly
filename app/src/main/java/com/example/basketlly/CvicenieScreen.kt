package com.example.basketlly

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Adapter
import androidx.appcompat.app.AppCompatActivity
import com.example.basketlly.databinding.CvicenieScreenBinding
import java.text.NumberFormat

//class CvicenieScreenAktivita : Fragment(R.layout.cvicenie_screen){

class CvicenieScreen: AppCompatActivity() {

    private lateinit var binding: CvicenieScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = CvicenieScreenBinding.inflate(layoutInflater)
            setContentView(binding.root)
            percentoStrelby()
            //binding.buttonAddExercise.setOnClickListener{}

    }

    private fun percentoStrelby() {
        val nazovTextPole = binding.nameExercise.text
        val daneTextPole = binding.numberSuccessfulAttempts.text.toString()
        val pokusyTextPole = binding.nameAllAttempts.text.toString()

        val overenieNazovTextPole = nazovTextPole.toString()
        val overenieDaneTextPole = daneTextPole.toIntOrNull()
        val overeniePokusyTextPole = pokusyTextPole.toIntOrNull()

        if ( overenieDaneTextPole == null && overeniePokusyTextPole == null ) {
            binding.percentageOfExercise.text = " "
            return
        }

        val percento = overenieDaneTextPole!! / overeniePokusyTextPole!! *100
        //val formattedPercento = NumberFormat.getCurrencyInstance().format(percento)
        val percentoString = percento.toString()+"%"

        displayPercento(percento)

        //binding.percentageOfExercise.setText(percentoString)

        var dataCvicenie = DataCvicenie(overenieNazovTextPole, overenieDaneTextPole, overenieDaneTextPole)
    }

    private fun displayPercento(percento: Int) {
        val formattedPercento = NumberFormat.getCurrencyInstance().format(percento)
        binding.percentageOfExercise.text = getString(R.string.percentage, formattedPercento)
    }

}