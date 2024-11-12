package com.example.api.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.api.Model.Province
import com.example.api.R

class ProvinceAdapter(private val provinces: List<Province>) : RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        // Menggunakan layout sederhana untuk setiap item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_province, parent, false)
        return ProvinceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
        holder.bind(provinces[position])
    }

    override fun getItemCount(): Int = provinces.size

    class ProvinceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val provinceNameTextView: TextView = itemView.findViewById(R.id.provinceName)

        fun bind(province: Province) {
            // Menampilkan nama provinsi
            provinceNameTextView.text = province.nama
        }
    }
}
