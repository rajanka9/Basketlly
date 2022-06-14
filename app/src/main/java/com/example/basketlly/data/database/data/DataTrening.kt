package com.example.basketlly.data.database.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
@Entity
data class DataTrening(
    val nazov : String,
    val datum : String,
    val lopta : Int,
    @PrimaryKey val id: Int? = null
) //: Serializable*/


data class DataTrening(
    val nazov : String,
    val datum : String,
    val lopta : Int,
    //@PrimaryKey val id: Int? = null
) //: Serializable
