package com.example.assignmentfinal.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentfinal.R
import com.example.assignmentfinal.adapters.SurahAdapter
import com.example.assignmentfinal.models.DataSurah
import com.example.assignmentfinal.models.SurahModel
import com.example.assignmentfinal.services.SurahApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SurahFragment : Fragment() {
    private lateinit var recyclerview_surah: RecyclerView
    lateinit var surahApiInterface: SurahApiInterface
    private var URL_SURAH = "https://quran-api-id.vercel.app/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var retrofit = Retrofit.Builder()
            .baseUrl(URL_SURAH)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        surahApiInterface = retrofit.create(SurahApiInterface::class.java)

        getSurahFromApi()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_surah, container, false)
        return view
    }

    fun getSurahFromApi() {
        val surahModelList = ArrayList<DataSurah>()

        var call: Call<SurahModel> = surahApiInterface.getSurah()

        call.enqueue(object: Callback<SurahModel> {
            override fun onResponse(call: Call<SurahModel>, response: Response<SurahModel>) {
                if (response.isSuccessful) {
                    for (data in response.body()?.getDataSurah()!!) {
                        surahModelList.add(data)
                    }
                    recyclerview_surah = requireView().findViewById(R.id.recyclerview_surah)
                    recyclerview_surah.setHasFixedSize(true)
                    recyclerview_surah.layoutManager = LinearLayoutManager(context)
                    var adaptor = SurahAdapter(surahModelList)
                    recyclerview_surah.adapter = adaptor
                }
            }

            override fun onFailure(call: Call<SurahModel>, t: Throwable) {
                Log.e("TAG", "ERROR OCCURED...")
            }

        })
    }
}