package com.example.assignmentfinal.adapters

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentfinal.DetailActivity
import com.example.assignmentfinal.R
import com.example.assignmentfinal.models.DataSurah

class SurahAdapter (private var surahModelList: ArrayList<DataSurah>) : RecyclerView.Adapter<SurahAdapter.ViewHolder>() {
    fun SurahAdapter(surahModelList: ArrayList<DataSurah>) {
        this.surahModelList = surahModelList
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemNomor: TextView
        var itemSurah: TextView
        var itemArti: TextView
        var itemAyat: TextView
        var itemDescription: TextView
        var itemAudio: TextView
        var itemTipe: TextView
        var itemCard: CardView

        init {
            itemNomor = itemView.findViewById(R.id.no_surah)
            itemSurah = itemView.findViewById(R.id.nama_surah)
            itemArti = itemView.findViewById(R.id.arti_surah)
            itemAyat = itemView.findViewById(R.id.jumlah_ayat)

            // INVISIBLE
            itemDescription = itemView.findViewById(R.id.description_surah)
            itemAudio = itemView.findViewById(R.id.audio_surah)
            itemTipe = itemView.findViewById(R.id.tipe_surah)

            // CARD
            itemCard = itemView.findViewById(R.id.cardview_surah)

            itemCard.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("no_surah", itemNomor.text)
                intent.putExtra("nama_surah", itemSurah.text)
                intent.putExtra("arti_surah", itemArti.text)
                intent.putExtra("ayat_surah", itemAyat.text)
                intent.putExtra("deskripsi_surah", itemDescription.text)
                intent.putExtra("audio_surah", itemAudio.text)
                intent.putExtra("tipe_surah", itemTipe.text)

                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_surah, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemNomor.setText(surahModelList.get(position).getNoSurah())
        holder.itemSurah.setText(surahModelList.get(position).getNamaSurah())
        holder.itemArti.setText(surahModelList.get(position).getArtiSurah())
        holder.itemAyat.setText(surahModelList.get(position).getAyatSurah())
        holder.itemDescription.setText(surahModelList.get(position).getDescription())
        holder.itemAudio.setText(surahModelList.get(position).getAudio())
        holder.itemTipe.setText(surahModelList.get(position).getTipe())

        if (position % 2 != 0) {
            holder.itemCard.setCardBackgroundColor(Color.rgb(231, 232, 195))
        }
        else {
            holder.itemCard.setCardBackgroundColor(Color.WHITE)
        }
    }

    override fun getItemCount(): Int {
        return surahModelList.size
    }
}