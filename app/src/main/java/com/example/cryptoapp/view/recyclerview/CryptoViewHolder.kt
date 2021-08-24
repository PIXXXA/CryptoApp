package com.example.cryptoapp.view.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.comparePercentChanges
import com.example.cryptoapp.databinding.RecyclerViewItemBinding
import com.example.cryptoapp.model.CryptoDataListModel

class CryptoViewHolder(private val binding: RecyclerViewItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun populate(modelData: CryptoDataListModel) {
        val resources = binding.root.context.resources
        binding.cryptoTitle.text =
            "${resources.getString(R.string.recycler_title)} ${modelData.name}"
        binding.growthIndicator.comparePercentChanges(modelData.percent_change_1h)
        binding.cryptoPrice.text =
            "${resources.getString(R.string.recycler_price)} ${modelData.price_usd}"
        binding.cryptoVolume.text =
            "${resources.getString(R.string.recycler_volume)} ${modelData.volume24}"
        binding.cryptoPercentChange24.text =
            "${resources.getString(R.string.recycler_percent_change_24)} ${modelData.percent_change_24h}"
    }
}