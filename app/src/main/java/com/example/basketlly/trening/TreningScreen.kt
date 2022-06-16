package com.example.basketlly.trening

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basketlly.R
import com.example.basketlly.TreningAdapter
import com.example.basketlly.cvicenia.CvicenieScreen
import com.example.basketlly.data.DataCvicenie
import com.example.basketlly.treningy.TreningyScreen
import com.example.basketlly.databinding.TreningScreenBinding

// Trieda TreningScreen nam nacita data z predchadzajucej aktivity a pomocou recyclerView nam ich zobrazi
// dalej si vie user zaznamenat s akou loptou dany trening vykonaval, ako sa vola trening a v aky den ho odtrenoval

/**
 * Trening screen
 *
 * @constructor Create empty Trening screen
 */
class TreningScreen: AppCompatActivity() {

    private lateinit var binding: TreningScreenBinding
    var cviceniaList = mutableListOf<DataCvicenie>()


    /**
     * On create
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TreningScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = TreningAdapter(cviceniaList)
        val recyclerPohladov2 = binding.recyclerViewExercises
        recyclerPohladov2.adapter = adapter
        recyclerPohladov2.layoutManager = LinearLayoutManager(this)

        cviceniaList.add(DataCvicenie("xxxxxxxxx","0", "0", "0"))

        val nazov = intent.getStringExtra("EXTRA_SENDDATA").toString()
        val dane = intent.getStringExtra("EXTRA_SENDDANE").toString()
        val pokusy = intent.getStringExtra("EXTRA_SENDPOKUSY").toString()
        val percento = intent.getStringExtra("EXTRA_SENDPERCENTO").toString()

        if (dane.isEmpty() || pokusy.isEmpty() || percento.isEmpty()){
                val dataCv = DataCvicenie("x", "0", "0", "0")
        }

        val dataCv = DataCvicenie(nazov, dane, pokusy, percento)
        cviceniaList.add(dataCv)
        adapter.notifyItemInserted(cviceniaList.size - 1)

        binding.btnNewExercise.setOnClickListener {
            Intent(this, CvicenieScreen::class.java).also { startActivity(it) }
        }

        binding.buttonAddTraining.setOnClickListener {

            val treningNazov = binding.nameExercise.text.toString()
            val treningDatum = binding.trainingDate.text.toString()
            val treningLopta = when (binding.radioGroupBalls.checkedRadioButtonId) {
                R.id.ball_size_3x3 -> "3x3"
                R.id.ball_size_7 -> "7"
                else -> "6"
            }

            if (treningNazov.isNotEmpty() && treningDatum.isNotEmpty() && treningLopta.isNotEmpty()) {
                Intent(this, TreningyScreen::class.java).also {
                    it.putExtra("EXTRA_TRENINGNAZOV", treningNazov)
                    it.putExtra("EXTRA_TRENINGDATUM", treningDatum)
                    it.putExtra("EXTRA_TRENINGLOPTA", treningLopta)

                    startActivity(it)
                }
                finish()
            } else {
                if(treningNazov.isBlank() ||  treningDatum.isEmpty()) {
                    val toast = Toast.makeText(this, "Please, fill everything :(", Toast.LENGTH_SHORT)
                    toast.show()
                }

              return@setOnClickListener
            }

        }

    }


    /**
     * On save instance state
     *
     * @param outState
     */

    override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
            Log.i(TAG, "onSaveInstanceState")

        }

    /*override fun onBackPressed() {
        super.onBackPressed()

    }*/

}


