package com.example.basketlly.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.basketlly.data.database.dao.CvicenieDao
import com.example.basketlly.data.database.dao.TreningDao
import com.example.basketlly.data.database.data.DataCvicenie
import com.example.basketlly.data.database.data.DataTrening

@Database(
    entities = [DataCvicenie::class, DataTrening::class],
    version = 1
)
abstract  class AppDatabase : RoomDatabase() {

    abstract val cvicenieDao: CvicenieDao
    abstract val treningDao: TreningDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}

