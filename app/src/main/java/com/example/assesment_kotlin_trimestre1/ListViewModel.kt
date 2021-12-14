package com.example.assesment_kotlin_trimestre1

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assesment_kotlin_trimestre1.data.Lead
import com.example.assesment_kotlin_trimestre1.data.LeadDao
import kotlinx.coroutines.launch
import javax.sql.CommonDataSource

class ListViewModel(val dataSource: LeadDao, application: Application) : ViewModel() {

    val leads = dataSource.getAll()

    fun incluir(lead:Lead) {
        viewModelScope.launch {
            dataSource.create(lead)
        }
    }

}