package com.example.assesment_kotlin_trimestre1.List

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assesment_kotlin_trimestre1.data.Lead

class LeadAdapter: RecyclerView.Adapter<LeadHolder>() {

    var data = listOf<Lead>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeadHolder {

        return LeadHolder.gerar(parent)
    }

    override fun onBindViewHolder(holder: LeadHolder, position: Int) {

        val lead = data[position]
        holder.relate(lead)
    }

    override fun getItemCount() = data.size
}