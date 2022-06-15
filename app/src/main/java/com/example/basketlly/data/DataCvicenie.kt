package com.example.basketlly.data

/*
@Entity
data class DataCvicenie(
    var nazov : String,
    var dane : Int,
    var pokusy : Int,
    var percento : Int,
    var idTreningu : Int,
    @PrimaryKey val id: Int? = null
)*/

import java.io.Serializable
data class DataCvicenie (
    val nazov : String,
    /*val dane : Int,
    val pokusy : Int,
    val percento : Int*/

    val dane : String,
    val pokusy : String,
    val percento : String
): Serializable // aby sme ju mohli parsovat a posielat medzi aktivitami

