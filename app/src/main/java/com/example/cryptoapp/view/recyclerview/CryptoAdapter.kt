package com.example.cryptoapp.view.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.RecyclerViewItemBinding
import com.example.cryptoapp.model.CryptoDetailsModel

class CryptoAdapter(private val model: List<CryptoDetailsModel>) :
    RecyclerView.Adapter<CryptoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return CryptoViewHolder(RecyclerViewItemBinding.bind(view))
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.populate(model[position])
    }

    override fun getItemCount(): Int = model.size
}