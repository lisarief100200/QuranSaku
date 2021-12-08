package com.example.assignmentfinal.models

import com.google.gson.annotations.SerializedName

class DataSurah {
    @SerializedName("number")
    private var noSurah: String? = null

    @SerializedName("name")
    private var namaSurah: String? = null

    @SerializedName("translation")
    private var artiSurah: String? = null

    @SerializedName("numberOfAyahs")
    private var ayatSurah: String? = null

    @SerializedName("description")
    private var description: String? = null

    @SerializedName("audio")
    private var audio: String? = null

    @SerializedName("revelation")
    private var tipe: String? = null

    fun getNoSurah(): String {
        return noSurah.toString()
    }

    fun getNamaSurah(): String {
        return namaSurah.toString()
    }

    fun getArtiSurah(): String {
        return artiSurah.toString()
    }

    fun getAyatSurah(): String {
        return ayatSurah.toString()
    }

    fun getDescription(): String {
        return description.toString()
    }

    fun getAudio(): String {
        return audio.toString()
    }

    fun getTipe(): String {
        return tipe.toString()
    }
}