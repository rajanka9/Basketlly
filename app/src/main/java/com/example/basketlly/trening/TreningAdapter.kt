package com.example.basketlly

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basketlly.data.database.data.DataCvicenie
import com.example.basketlly.data.database.data.DataTrening
import com.example.basketlly.databinding.ItemCvicenieBinding
import com.example.basketlly.databinding.ItemTreningBinding
import java.util.ArrayList

class TreningAdapter(
    val cvicenia: List<DataCvicenie>
): RecyclerView.Adapter<TreningAdapter.treningViewHolder>() {

    inner class treningViewHolder(val binding: ItemCvicenieBinding) : RecyclerView.ViewHolder(binding.root){
        /*internal fun bind(position: Int) {
            // this method will be called anytime a list item is created or updated its data
        }*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): treningViewHolder {
        val layoutInf = LayoutInflater.from(parent.context)
        val binding = ItemCvicenieBinding.inflate(layoutInf, parent, false)
        return treningViewHolder(binding)
    }

    override fun onBindViewHolder(holder: treningViewHolder, position: Int) {
        holder.binding.apply {
            itemNameExercise.text = cvicenia[position].nazov
            itemSuccAttempts.text = cvicenia[position].dane.toString()
            itemAllAttempts.text = cvicenia[position].pokusy.toString()
            itemPercentageHodnota.text = cvicenia[position].percento.toString()
        }
    }

    override fun getItemCount(): Int {
        return cvicenia.size
    }
}