package com.example.assignmentfinal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentfinal.R
import com.example.assignmentfinal.models.DataAyat

class AyatAdapter (private var ayatModelList: ArrayList<DataAyat>) : RecyclerView.Adapter<AyatAdapter.ViewHolder>() {
    fun AyatAdapter(ayatModelList: ArrayList<DataAyat>) {
        this.ayatModelList = ayatModelList
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemArab: TextView
        var itemArti: TextView

        init {
            itemArab = itemView.findViewById(R.id.arab_ayat)
            itemArti = itemView.findViewById(R.id.arti_ayat)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_ayat, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemArab.setText(ayatModelList.get(position).getArabAyat())
        holder.itemArti.setText(ayatModelList.get(position).getArtiAyat())
    }

    override fun getItemCount(): Int {
        return ayatModelList.size
    }
}