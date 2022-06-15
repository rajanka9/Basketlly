package com.example.basketlly.data

/*
@Entity
data class DataTrening(
    val nazov : String,
    val datum : String,
    val lopta : Int,
    @PrimaryKey val id: Int? = null
) //: Serializable*/

import java.io.Serializable
data class DataTrening(
    val nazov : String,
    val datum : String,
    val lopta : Int
) : Serializable
