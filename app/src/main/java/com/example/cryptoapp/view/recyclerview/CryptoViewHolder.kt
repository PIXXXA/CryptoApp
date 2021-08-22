package com.example.cryptoapp.view.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.RecyclerViewItemBinding
import com.example.cryptoapp.model.CryptoDetailsModel

class CryptoViewHolder(private val binding: RecyclerViewItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun populate(model: CryptoDetailsModel) {
        binding.cryptoTitle.text =
            binding.root.context.getString(R.string.recycler_title).plus(" ").plus(model.name)
        binding.cryptoPrice.text =
            binding.root.context.getString(R.string.recycler_price).plus(" ").plus(model.price_usd)
        binding.cryptoVolume.text =
            binding.root.context.getString(R.string.recycler_volume).plus(" ").plus(model.volume24)
        binding.cryptoPercentChange24.text =
            binding.root.context.getString(R.string.recycler_percent_change_24).plus(" ")
                .plus(model.percent_change_24h)
    }
}