package com.example.basketlly.data.database.data
import androidx.room.Entity
import androidx.room.PrimaryKey
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

data class DataCvicenie (
    var nazov : String,
    var dane : Int,
    var pokusy : Int,
    var percento : Int,
    //var idTreningu : Int,
    //@PrimaryKey val id: Int? = null
)//: Serializable // aby sme ju mohli parsovat a posielat medzi aktivitami

