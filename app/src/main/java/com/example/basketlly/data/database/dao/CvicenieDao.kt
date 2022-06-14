package com.example.basketlly.data.database.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import com.example.basketlly.data.database.data.DataCvicenie

@Dao
interface CvicenieDao {

    //this return flow
    @Query("SELECT * FROM DataCvicenie")
    fun getCvicenia(): Flow<List<DataCvicenie>>

    @Query("SELECT * FROM DataCvicenie WHERE id = :id")
    suspend fun getCvicenieById(id: Int): DataCvicenie?

    @Insert (onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertCvicenie(dataCvicenie: DataCvicenie)

    @Delete
    suspend fun deleteCvicenie(dataCvicenie: DataCvicenie)


}