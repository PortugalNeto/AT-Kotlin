package com.example.assesment_kotlin_trimestre1.List

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assesment_kotlin_trimestre1.R
import com.example.assesment_kotlin_trimestre1.data.Lead

// Função -> Encapsular a relação entre o dado e a linha (layout)
class LeadHolder(view: View): RecyclerView.ViewHolder(view) {

    val campoNome = view.findViewById<TextView>(R.id.txtNome)
    val campoTelefone = view.findViewById<TextView>(R.id.txtTelefone)
    val campoEmail = view.findViewById<TextView>(R.id.txtEmail)

    fun relate(lead: Lead) {

        campoNome.text = "Nome: ${lead.Nome}"
        campoTelefone.text = "Tel: ${lead.Telefone}"
        campoEmail.text = "Email: ${lead.Email}"
    }

    companion object {
        fun gerar(parent: ViewGroup): LeadHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.lead_item, parent, false)

            return LeadHolder(view)
        }
    }


}