package com.example.assesment_kotlin_trimestre1.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assesment_kotlin_trimestre1.List.LeadAdapter
import com.example.assesment_kotlin_trimestre1.ListLeadViewModelFactory
import com.example.assesment_kotlin_trimestre1.ListViewModel
import com.example.assesment_kotlin_trimestre1.R
import com.example.assesment_kotlin_trimestre1.data.Lead
import com.example.assesment_kotlin_trimestre1.data.LeadDb

class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(this.activity).application

        val root =  inflater.inflate(R.layout.list_fragment, container, false)
        val dataSource = LeadDb.getInstance(application).leadDao
        val factory = ListLeadViewModelFactory(dataSource, application)
        viewModel = ViewModelProvider(this, factory).get(ListViewModel::class.java)
        val adapter = LeadAdapter()
        val list = root.findViewById<RecyclerView>(R.id.lstLeads)
        list.layoutManager = LinearLayoutManager(application)
        list.adapter = adapter

        viewModel.leads.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        val edtNome = root.findViewById<EditText>(R.id.edtNome)
        val edtTelefone = root.findViewById<EditText>(R.id.edtTelefone)
        val edtEmail = root.findViewById<EditText>(R.id.edtEmail)
        val btnSalvar = root.findViewById<Button>(R.id.btnSalvar)

        btnSalvar.setOnClickListener {

            val nome = edtNome.text.toString()
            val telefone = edtTelefone.text.toString()
            val email = edtEmail.text.toString()
            val lead = Lead(0L, nome, telefone, email)

            viewModel.incluir(lead)
        }
        return root
    }
}