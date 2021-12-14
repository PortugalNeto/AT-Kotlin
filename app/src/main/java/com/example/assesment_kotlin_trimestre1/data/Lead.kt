package com.example.assesment_kotlin_trimestre1.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lead_table")
data class Lead(

    @PrimaryKey(autoGenerate = true)
    var Id: Long = 0L,

    @ColumnInfo(name = "nome")
    val Nome: String,

    @ColumnInfo(name = "telefone")
    val Telefone: String,

    @ColumnInfo(name = "email")
    val Email: String
)
