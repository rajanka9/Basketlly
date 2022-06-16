package com.example.basketlly.data

/*
@Entity
data class DataTrening(
    val nazov : String,
    val datum : String,
    val lopta : Int,
    @PrimaryKey val id: Int? = null
) //: Serializable*/

// Datova trieda sluzi na uchovavanie dat
import java.io.Serializable
data class DataTrening(
    val nazov : String,
    val datum : String,
    val lopta : String
) : Serializable // pridavanie Serializable aby sme ju mohli parsovat a posielat medzi aktivitami
