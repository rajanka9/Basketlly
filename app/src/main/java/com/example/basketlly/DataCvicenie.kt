package com.example.basketlly

import java.io.Serializable

data class DataCvicenie(
    var nazov : String,
    var dane : Int,
    var pokusy : Int,
    var uspesnost : Int
) : Serializable // aby sme ju mohli parsovat a posielat medzi aktivitami

