package com.example.basketlly.treningy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basketlly.R
import com.example.basketlly.data.DataTrening
import com.example.basketlly.databinding.ItemTreningBinding


// Trieda TreningyAdapter, ktora ma za ulohu vytvorit recyclerView s pozadovanym itemom

/* recycler view - https://www.youtube.com/watch?v=-PIKVIJb7Xs
- https://www.youtube.com/watch?v=HtwDXRWjMcU
- https://www.youtube.com/watch?v=HtwDXRWjMcU&list=PLQkwcJG4YTCTq1raTb5iMuxnEB06J1VHX&index=21 */

class TreningyAdapter(
    val treningy: List<DataTrening>
) : RecyclerView.Adapter<TreningyAdapter.TreningyViewHolder>(){

    inner class TreningyViewHolder(val binding: ItemTreningBinding) : RecyclerView.ViewHolder(binding.root)


    /**
     * On create view holder
     *
     * @param parent
     * @param viewType
     * @return
     */// to inflate the layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreningyViewHolder {
        val layoutInf = LayoutInflater.from(parent.context)
        val binding = ItemTreningBinding.inflate(layoutInf, parent, false)
        return TreningyViewHolder(binding)
    }


    /**
     * On bind view holder
     *
     * @param holder
     * @param position
     */
    override fun onBindViewHolder(holder: TreningyViewHolder, position: Int) {
        holder.binding.apply {
            nameTraining.text = treningy[position].nazov
            dateTrainig.text = treningy[position].datum
            ballTextTrainig.text = treningy[position].lopta

            //val obrazky = arrayOf(R.drawable.background, R.drawable.background_2, R.drawable.background_3)
            /*when (treningy[position].lopta) {
                6 -> imageTraining.setImageResource(obrazky[1])
                7 -> imageTraining.setImageResource(obrazky[2])
                3 -> imageTraining.setImageResource(obrazky[3])
            }*/ // na tomto to pada
        }
    }


    /**
     * Get item count
     *
     * @return
     */
    override fun getItemCount(): Int {
        return treningy.size
    }

}