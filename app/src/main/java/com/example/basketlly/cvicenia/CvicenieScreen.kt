package com.example.basketlly.cvicenia

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basketlly.R
import com.example.basketlly.treningy.TreningyScreen
import com.example.basketlly.data.DataCvicenie
import com.example.basketlly.databinding.CvicenieScreenBinding
import com.example.basketlly.trening.TreningScreen

// Zdroje:
// - app ktora nam vypocita percento z "tipu" z 4teho cicenia
// Passing data between activities - https://www.youtube.com/watch?v=IWXYV1dC2FQ
class CvicenieScreen: AppCompatActivity() {

    private lateinit var binding: CvicenieScreenBinding

    //private var dataCvicenie:
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = CvicenieScreenBinding.inflate(layoutInflater)
            setContentView(binding.root)

        binding.buttonPercentageExercise.setOnClickListener{ percentoStrelby() }
        binding.buttonAddExercise.setOnClickListener{
            val sendNazov = binding.nameExercise.text
            val sendDane = binding.numberSuccessfulAttempts.text.toString()
            val sendPokusy = binding.numberAllAttempts.text.toString()
            val dataJednoCviko = DataCvicenie(sendNazov.toString(),sendDane.toInt(), sendPokusy.toInt())

            if (sendNazov.isNotEmpty() && sendDane.toString().isNotEmpty() && sendPokusy.toString().isNotEmpty()
                    && sendPokusy.toInt() != 0 && sendPokusy.toInt() > sendDane.toInt()) {
                /*Intent(this, TreningScreen::class.java).also {
                    it.putExtra("EXTRA_DATAJEDNOCVIKO", dataJednoCviko)
                    startActivity(it)
                }*/

                   Intent(this, TreningScreen::class.java).also{
                        startActivity(it)
                    }
                finish()
            }

            if (sendNazov.isNullOrEmpty() || sendDane.isNullOrEmpty() || sendPokusy.isNullOrEmpty()) {
                val toast = Toast.makeText(this, "Please, fill each text field :)", Toast.LENGTH_SHORT)
                toast.show()
                return@setOnClickListener
            }

            if (sendPokusy.toInt() == 0) {
                val toast = Toast.makeText(this, "Division by zero!", Toast.LENGTH_SHORT)
                toast.show()
                return@setOnClickListener
            }

            if (sendNazov.isNullOrEmpty() && sendDane.isNullOrEmpty() && sendPokusy.isNullOrEmpty()) {
                val toast = Toast.makeText(this, "Chyba :(", Toast.LENGTH_SHORT)
                toast.show()
                return@setOnClickListener
            }


        }


    }

    private fun percentoStrelby() {
        //val nazovTextPole = binding.nameExercise.text
        val daneTextPole = binding.numberSuccessfulAttempts.text.toString()
        val pokusyTextPole = binding.numberAllAttempts.text.toString()

        val daneHodnota = daneTextPole.toIntOrNull()
        val pokusyHodnota = pokusyTextPole.toIntOrNull()

        if(daneTextPole.isNullOrEmpty() || pokusyTextPole.isNullOrEmpty()) {
            binding.percentageOfExercise.text = ""

            val toast = Toast.makeText(this, "Please, fill both successfull and all attempts :)", Toast.LENGTH_SHORT)
            toast.show()

            return
        }

        if (daneHodnota!! > pokusyHodnota!! && pokusyHodnota != 0) {
            binding.percentageOfExercise.text = ""

            val toast = Toast.makeText(this, "successful > all --> mistake!", Toast.LENGTH_SHORT)
            toast.show()

            return
        }

        if (pokusyHodnota == 0) {
            val toast = Toast.makeText(this, "Division by zero!", Toast.LENGTH_SHORT)
            toast.show()
            displayPercento(0)
            return
        }

        if ( daneHodnota == 0 ) {
            displayPercento(0)
            return
        }

        val percento = (daneHodnota.toDouble() / pokusyHodnota * 100).toInt()
        displayPercento(percento)
    }

    private fun displayPercento(percento: Int) {
        binding.percentageOfExercise.text = getString(R.string.percentage, percento.toString()+"%")
    }

}