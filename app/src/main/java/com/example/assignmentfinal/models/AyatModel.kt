package com.example.assignmentfinal.models

import com.google.gson.annotations.SerializedName

class AyatModel {
    @SerializedName("data")
    private var dataAyat: List<DataAyat>? = null

    fun getDataAyat(): List<DataAyat> {
        return dataAyat!!
    }
}