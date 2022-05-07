package com.example.basketlly

import java.io.Serializable

data class DataCvicenie(
    val nazov : String,
    val dane : Int,
    val pokusy : Int,
    val uspesnost : Int
) : Serializable // aby sme ju mohli parsovat a posielat medzi aktivitami

