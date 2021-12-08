package com.example.assignmentfinal.services

import com.example.assignmentfinal.models.SurahModel
import retrofit2.Call
import retrofit2.http.GET

interface SurahApiInterface {
    @GET("surahs")
    fun getSurah(): Call<SurahModel>
}