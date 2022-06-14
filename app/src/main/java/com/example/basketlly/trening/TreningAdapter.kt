package com.example.basketlly

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basketlly.data.DataCvicenie
import java.util.ArrayList

class CvicenieAdapter(val c: Context, private val cvicenieList:ArrayList<DataCvicenie>): RecyclerView.Adapter<CvicenieAdapter.cvicenieViewHolder>() {

    inner class cvicenieViewHolder(val v:View):RecyclerView.ViewHolder(v){
        val nazov = v.findViewById<TextView>(R.id.item_name_exercise)
        val dane_a_pokusy = v.findViewById<TextView>(R.id.item_attempts)
        val percento = v.findViewById<TextView>(R.id.item_percentage)

        /*internal fun bind(position: Int) {
            // this method will be called anytime a list item is created or updated its data
        }*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cvicenieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_cvicenie, parent, false)
        return cvicenieViewHolder(v)
    }

    override fun onBindViewHolder(holder: cvicenieViewHolder, position: Int) {
        val newList = cvicenieList[position]
        holder.nazov.text = newList.nazov
        //getString(holder.dane_a_pokusy.text , newList.dane.toString())
        holder.percento.text = newList.uspesnost.toString()
    }

    override fun getItemCount(): Int {
        return cvicenieList.size
    }
}