package com.example.assignmentfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentfinal.adapters.AyatAdapter
import com.example.assignmentfinal.models.AyatModel
import com.example.assignmentfinal.models.DataAyat
import com.example.assignmentfinal.services.AyatApiInterface
import kotlinx.android.synthetic.main.activity_ayat.*
import kotlinx.android.synthetic.main.row_ayat.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AyatActivity : AppCompatActivity() {
    var bundle: Bundle? = null
    private lateinit var recycler_ayat: RecyclerView
    lateinit var ayatApiInterface: AyatApiInterface
    private var URL_AYAT_NY = "https://quran-api-id.vercel.app/surahs/"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayat)

        recycler_ayat = findViewById(R.id.recyclerview_ayat)
        recycler_ayat.setHasFixedSize(true)
        recycler_ayat.layoutManager = LinearLayoutManager(applicationContext)

        bundle = intent.extras
        var noSurah = bundle?.getString("no_surah")
        var URL_AYAT = URL_AYAT_NY + noSurah + "/"

        var retrofit = Retrofit.Builder()
            .baseUrl(URL_AYAT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        ayatApiInterface = retrofit.create(AyatApiInterface::class.java)

        getAyatFromApi()
    }

    fun getAyatFromApi() {
        val ayatModelList = ArrayList<DataAyat>()

        val call: Call<AyatModel> = ayatApiInterface.getAyat()

        call.enqueue(object: Callback<AyatModel> {
            override fun onResponse(call: Call<AyatModel>, response: Response<AyatModel>) {
                if (response.isSuccessful) {
                    for (data in response.body()?.getDataAyat()!!) {
                        ayatModelList.add(data)
                    }
                    var adaptor = AyatAdapter(ayatModelList)
                    recycler_ayat.adapter = adaptor
                }
            }

            override fun onFailure(call: Call<AyatModel>, t: Throwable) {
                Log.e("TAG", "ERROR OCCURED...")
            }

        })
    }
}