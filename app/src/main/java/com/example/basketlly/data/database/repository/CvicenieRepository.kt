package com.example.basketlly.data.database.repository

import com.example.basketlly.data.database.data.DataCvicenie
import kotlinx.coroutines.flow.Flow

interface CvicenieRepository {

    fun getCvicenia(): Flow<List<DataCvicenie>>

    suspend fun getCvicenieById(id: Int): DataCvicenie?

    suspend fun insertCvicenie(dataCvicenie: DataCvicenie)

    suspend fun deleteCvicenie(dataCvicenie: DataCvicenie)}