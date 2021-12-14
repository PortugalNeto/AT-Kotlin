package com.example.assesment_kotlin_trimestre1.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Lead::class], version = 1, exportSchema = false)
abstract class LeadDb: RoomDatabase() {

    abstract val leadDao: LeadDao

    companion object {
        @Volatile
        private var INSTANCE: LeadDb? = null

        fun getInstance(context: Context): LeadDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LeadDb::class.java,
                        "lead_database"
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}