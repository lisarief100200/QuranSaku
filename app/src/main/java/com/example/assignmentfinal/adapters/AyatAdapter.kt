package com.example.assignmentfinal.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
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
        var itemNomor: TextView
        var itemCard: CardView

        init {
            itemArab = itemView.findViewById(R.id.arab_ayat)
            itemArti = itemView.findViewById(R.id.arti_ayat)
            itemNomor = itemView.findViewById(R.id.no_ayat)
            itemCard = itemView.findViewById(R.id.cardview_ayat)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_ayat, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemArab.setText(ayatModelList.get(position).getArabAyat())
        holder.itemArti.setText(ayatModelList.get(position).getArtiAyat())
        val number = (position + 1) % (ayatModelList.size + 1)
        holder.itemNomor.text = number.toString()

        if (position % 2 != 0) {
            holder.itemCard.setCardBackgroundColor(Color.rgb(231, 232, 195))
        }
        else {
            holder.itemCard.setCardBackgroundColor(Color.WHITE)
        }
    }

    override fun getItemCount(): Int {
        return ayatModelList.size
    }
}