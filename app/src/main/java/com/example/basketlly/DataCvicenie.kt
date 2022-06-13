package com.example.basketlly

import java.io.Serializable

data class DataCvicenie(
    var nazov : String,
    var dane : Int,
    var pokusy : Int,
    var uspesnost : Int = (dane.toDouble() / pokusy * 100).toInt()
) : Serializable // aby sme ju mohli parsovat a posielat medzi aktivitami

