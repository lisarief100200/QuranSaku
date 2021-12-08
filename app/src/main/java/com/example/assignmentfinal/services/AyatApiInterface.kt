package com.example.assignmentfinal.services

import com.example.assignmentfinal.models.AyatModel
import retrofit2.Call
import retrofit2.http.GET

interface AyatApiInterface {
    @GET("ayahs")
    fun getAyat(): Call<AyatModel>
}