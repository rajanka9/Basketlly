package com.example.basketlly.data.database.repository

import com.example.basketlly.data.database.dao.CvicenieDao
import com.example.basketlly.data.database.dao.TreningDao
import com.example.basketlly.data.database.data.DataTrening
import kotlinx.coroutines.flow.Flow

class ImplTrenRepos (
    private val dao: TreningDao
    ) : TreningRepository{
    override fun getTreningy(): Flow<List<DataTrening>> {
        return dao.getTreningy()
    }

    override suspend fun getTreningById(id: Int): DataTrening? {
        return dao.getTreningById(id)
    }

    override suspend fun insertTrening(dataTrening: DataTrening) {
        dao.insertTrening(dataTrening)
    }

    override suspend fun deleteTrening(dataTrening: DataTrening) {
        dao.deleteTrening(dataTrening)
    }
}