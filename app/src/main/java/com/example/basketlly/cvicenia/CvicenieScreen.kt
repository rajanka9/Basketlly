package com.example.basketlly.cvicenia

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basketlly.R
import com.example.basketlly.data.DataCvicenie
//import com.example.basketlly.database.AppDatabase
import com.example.basketlly.databinding.CvicenieScreenBinding
import com.example.basketlly.trening.TreningScreen


// Trieda CvicenieScreen je aktivitou kedy nam po zadani cisel (dane a pokusy strelby) vrati ich percento
// Dalej tato trieda posiela tieto data do dalsej aktivity

// Zdroje:
// - app ktora nam vypocita percento z "tipu" z 4teho cicenia

/*
    prechod medzi snimkami - https://www.youtube.com/watch?v=UWqoz5Kln4k
    passing data between activities - https://www.youtube.com/watch?v=IWXYV1dC2FQ
    activity X fragment - https://www.geeksforgeeks.org/difference-between-a-fragment-and-an-activity-in-android/

*/
class CvicenieScreen: AppCompatActivity() {

    private lateinit var binding: CvicenieScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CvicenieScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPercentageExercise.setOnClickListener { percentoStrelby() }

        binding.buttonAddExercise.setOnClickListener {
            val sendNazov = binding.nameExercise.text.toString()
            val sendDane = binding.numberSuccessfulAttempts.text.toString()
            val sendPokusy = binding.numberAllAttempts.text.toString()
            val sendPercento = (sendDane.toDouble() / sendPokusy.toInt() * 100).toInt()

            if (sendNazov.isNotEmpty() && sendDane.toString().isNotEmpty() && sendPokusy.toString()
                    .isNotEmpty()
                && sendPokusy.toInt() != 0 && sendPokusy.toInt() > sendDane.toInt()
            ) {

                Intent(this, TreningScreen::class.java).also {
                    it.putExtra("EXTRA_SENDDATA", sendNazov)
                    it.putExtra("EXTRA_SENDDANE", sendDane)
                    it.putExtra("EXTRA_SENDPOKUSY", sendPokusy)
                    it.putExtra("EXTRA_SENDPERCENTO", sendPercento.toString())
                    startActivity(it)
                }
                finish()
            } else {

                if (sendPokusy.toInt() == 0) {
                    val toast = Toast.makeText(this, "Division by zero!", Toast.LENGTH_SHORT)
                    toast.show()
                    return@setOnClickListener
                }

                if (sendDane.toInt() > sendPokusy.toInt() && sendPokusy.toInt() != 0) {
                    val toast =
                        Toast.makeText(this, "successful > all --> mistake!", Toast.LENGTH_SHORT)
                    toast.show()

                    return@setOnClickListener
                }

                //finish()
            }
            //finish()
        }
    }

    private fun percentoStrelby() {
        //val nazovTextPole = binding.nameExercise.text
        val daneTextPole = binding.numberSuccessfulAttempts.text.toString()
        val pokusyTextPole = binding.numberAllAttempts.text.toString()

        val daneHodnota = daneTextPole.toIntOrNull()
        val pokusyHodnota = pokusyTextPole.toIntOrNull()

        if (daneTextPole.isNullOrEmpty() || pokusyTextPole.isNullOrEmpty()) {
            binding.percentageOfExercise.text = ""

            val toast = Toast.makeText(
                this,
                "Please, fill both successfull and all attempts :)",
                Toast.LENGTH_SHORT
            )
            toast.show()

            return
        }

        if (daneHodnota!! > pokusyHodnota!! && pokusyHodnota != 0) {
            binding.percentageOfExercise.text = ""

            val toast =
                Toast.makeText(this, "successful > all --> mistake!", Toast.LENGTH_SHORT)
            toast.show()

            return
        }

        if (pokusyHodnota == 0) {
            val toast = Toast.makeText(this, "Division by zero!", Toast.LENGTH_SHORT)
            toast.show()
            displayPercento(0)
            return
        }

        if (daneHodnota == 0) {
            displayPercento(0)
            return
        }

        val percento = (daneHodnota.toDouble() / pokusyHodnota * 100).toInt()
        displayPercento(percento)
    }

    private fun displayPercento(percento: Int) {
        binding.percentageOfExercise.text =
            getString(R.string.percentage, percento.toString() + "%")
    }


}

