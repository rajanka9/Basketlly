package com.example.basketlly.data.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.basketlly.data.database.data.DataTrening
import kotlinx.coroutines.flow.Flow

interface TreningDao {
    //this return flow
    @Query("SELECT * FROM DataTrening")
    fun getTreningy(): Flow<List<DataTrening>>

    @Query("SELECT * FROM DataTrening WHERE id = :id")
    suspend fun getTreningById(id: Int): DataTrening?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrening(dataTrening: DataTrening)

    @Delete
    suspend fun deleteTrening(dataTrening: DataTrening)
}