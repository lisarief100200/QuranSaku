package com.example.assignmentfinal.models

import com.google.gson.annotations.SerializedName

class DataAyat {
    @SerializedName("arab")
    private var arabAyat: String? = null

    @SerializedName("translation")
    private var artiAyat: String? = null

    fun getArabAyat(): String {
        return arabAyat.toString()
    }

    fun getArtiAyat(): String {
        return artiAyat.toString()
    }
}