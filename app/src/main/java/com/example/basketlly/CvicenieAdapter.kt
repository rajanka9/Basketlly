package com.example.basketlly

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class CvicenieAdapter(val c: Context, val cvicenieList:ArrayList<DataCvicenie>): RecyclerView.Adapter<CvicenieAdapter.cvicenieViewHolder>() {

    /*(private val context: Activity, private val arrayList: ArrayList<DataCvicenie>):ArrayAdapter<DataCvicenie>(context,
    R.layout.item_cvicenie, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate((R.layout.item_cvicenie), null)

        val nazov: TextView = view.findViewById(R.id.item_name_exercise)
        val dane_a_pokusy: TextView = view.findViewById(R.id.item_attempts)
        val uspesnost: TextView = view.findViewById(R.id.item_percentage)

        return super.getView(position, convertView, parent)
    }*/

    inner class cvicenieViewHolder(val v:View):RecyclerView.ViewHolder(v){
        val nazov = v.findViewById<TextView>(R.id.item_name_exercise)
        val dane_a_pokusy = v.findViewById<TextView>(R.id.item_attempts)
        val percento = v.findViewById<TextView>(R.id.item_percentage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cvicenieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_cvicenie, parent, false)
        return cvicenieViewHolder(v)
    }

    override fun onBindViewHolder(holder: cvicenieViewHolder, position: Int) {
        val newList = cvicenieList[position]
        holder.nazov.text = newList.nazov
        holder.dane_a_pokusy.text = newList.dane.toString()+"/"+newList.pokusy.toString()
        holder.percento.text = newList.uspesnost.toString()+"%"
    }

    override fun getItemCount(): Int {
        return cvicenieList.size
    }
}