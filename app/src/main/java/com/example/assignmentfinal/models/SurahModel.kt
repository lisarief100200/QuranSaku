package com.example.assignmentfinal.models

import com.google.gson.annotations.SerializedName

class SurahModel {
    @SerializedName("data")
    private var dataSurah: List<DataSurah>? = null

    fun getDataSurah(): List<DataSurah> {
        return dataSurah!!
    }
}