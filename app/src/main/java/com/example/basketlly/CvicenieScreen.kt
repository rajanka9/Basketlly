package com.example.basketlly

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basketlly.databinding.CvicenieScreenBinding

// Zdroje: app ktora nam vypocita percento z "tipu" z 4teho cicenia
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
        val pokusyTextPole = binding.numberAllAttempts.text.toString()

        val daneHodnota = daneTextPole.toIntOrNull()
        val pokusyHodnota = pokusyTextPole.toIntOrNull()

        if(daneHodnota == null || pokusyHodnota == null || pokusyHodnota == 0 || daneHodnota>pokusyHodnota) {
            binding.percentageOfExercise.text = ""
            if (pokusyHodnota == 0)
            {val toast = Toast.makeText(this, "Division by zero!", Toast.LENGTH_SHORT)
            toast.show()}

            if (daneHodnota!! > pokusyHodnota!! && pokusyHodnota != 0)
            {val toast = Toast.makeText(this, "succesful attempts > all attempts --> mistake!", Toast.LENGTH_SHORT)
                toast.show()}
            return

        }

        if (daneHodnota == null || pokusyHodnota == null || daneHodnota == 0 )
        {
            displayPercento(0)
            return
        }

        val percento = (daneHodnota.toDouble() / pokusyHodnota * 100).toInt()
        displayPercento(percento)
    }

    private fun displayPercento(percento: Int) {
        //val formattedPercento = NumberFormat.getCurrencyInstance().format(percento)
        binding.percentageOfExercise.text = getString(R.string.percentage, percento.toString()+"%")
    }

}