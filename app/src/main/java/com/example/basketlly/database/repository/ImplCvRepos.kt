/*
package com.example.basketlly.database.repository

import com.example.basketlly.database.dao.CvicenieDao
import com.example.basketlly.data.DataCvicenie
import kotlinx.coroutines.flow.Flow

class ImplCvRepos (
    private val dao: CvicenieDao
        ) : CvicenieRepository{
    override fun getCvicenia(): Flow<List<DataCvicenie>> {
        return dao.getCvicenia()
    }

    override suspend fun getCvicenieById(id: Int): DataCvicenie? {
        return dao.getCvicenieById(id)
    }

    override suspend fun insertCvicenie(dataCvicenie: DataCvicenie) {
        dao.insertCvicenie(dataCvicenie)
    }

    override suspend fun deleteCvicenie(dataCvicenie: DataCvicenie) {
        dao.deleteCvicenie(dataCvicenie)
    }
}*/
