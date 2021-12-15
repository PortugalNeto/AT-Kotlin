package com.example.assesment_kotlin_trimestre1.data

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface LeadDao {

    // Busca todos os contatos da tabela:
    @Query("SELECT * FROM lead_table ORDER BY Nome")
    fun getAll(): LiveData<List<Lead>>

    // Para buscar um contato contatos da tabela pelo Id:
    @Query("SELECT * from lead_table WHERE Id = :key")
    fun get(key: Long): Lead
    //-------------------------------------------------------- ^ Get (Consultas)

    // Para Criar nossos Contatos:
    @Insert
    suspend fun create(lead: Lead)
    //-------------------------------------------------------- ^ Create

    // atualizar contato:
    @Update
    suspend fun update(lead: Lead)
    //-------------------------------------------------------- ^ Update

    @Delete
    suspend fun delete(lead: Lead)
    //-------------------------------------------------------- ^ Delete


}