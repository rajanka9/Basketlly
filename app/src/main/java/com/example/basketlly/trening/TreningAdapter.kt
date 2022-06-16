package com.example.basketlly

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basketlly.data.DataCvicenie
import com.example.basketlly.databinding.ItemCvicenieBinding

// Trieda TreningAdapter, ktora ma za ulohu vytvorit recyclerView s pozadovanym itemom

/* recycler view - https://www.youtube.com/watch?v=-PIKVIJb7Xs
- https://www.youtube.com/watch?v=HtwDXRWjMcU
- https://www.youtube.com/watch?v=HtwDXRWjMcU&list=PLQkwcJG4YTCTq1raTb5iMuxnEB06J1VHX&index=21 */

class TreningAdapter(
    val cvicenia: List<DataCvicenie>
): RecyclerView.Adapter<TreningAdapter.treningViewHolder>() {

    inner class treningViewHolder(val binding: ItemCvicenieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): treningViewHolder {
        val layoutInf = LayoutInflater.from(parent.context)
        val binding = ItemCvicenieBinding.inflate(layoutInf, parent, false)
        return treningViewHolder(binding)
    }

    override fun onBindViewHolder(holder: treningViewHolder, position: Int) {
        holder.binding.apply {
            itemNameExercise.text = cvicenia[position].nazov
            itemSuccAttempts.text = cvicenia[position].dane
            itemAllAttempts.text = cvicenia[position].pokusy
            itemPercentageHodnota.text = cvicenia[position].percento
        }
    }

    override fun getItemCount(): Int {
        return cvicenia.size
    }
}