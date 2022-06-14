package com.example.basketlly.treningy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basketlly.R
import com.example.basketlly.data.database.data.DataTrening
import com.example.basketlly.databinding.ItemTreningBinding

class TreningyAdapter(
    var treningy: List<DataTrening>
) : RecyclerView.Adapter<TreningyAdapter.TreningyViewHolder>(){

    inner class TreningyViewHolder(val binding: ItemTreningBinding) : RecyclerView.ViewHolder(binding.root)

    // to inflate the layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreningyViewHolder {
        val layoutInf = LayoutInflater.from(parent.context)
        val binding = ItemTreningBinding.inflate(layoutInf, parent, false)
        return TreningyViewHolder(binding)

        //val view = LayoutInflater.from(parent.context).inflate(R.layout.item_trening, parent, false)
        //return TreningyViewHolder(view)
    }

    override fun onBindViewHolder(holder: TreningyViewHolder, position: Int) {
        holder.binding.apply {
            nameTraining.text = treningy[position].nazov
            dateTrainig.text = treningy[position].datum

            val obrazky = arrayOf(R.drawable.basketball_black, R.drawable.basketball_blue, R.drawable.basketball_orange)

            when (treningy[position].lopta) {
                6 -> imageTraining.setImageResource(obrazky[1])
                7 -> imageTraining.setImageResource(obrazky[2])
                3 -> imageTraining.setImageResource(obrazky[3])
            }
        }
    }

    override fun getItemCount(): Int {
        return treningy.size
    }

}