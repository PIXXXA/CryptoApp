package com.example.cryptoapp.view.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.RecyclerViewItemBinding
import com.example.cryptoapp.model.CryptoDataListModel

class CryptoViewHolder(private val binding: RecyclerViewItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun populate(modelData: CryptoDataListModel) {
        binding.cryptoTitle.text = setViewFieldText(R.string.recycler_title, modelData.name)
        binding.cryptoPrice.text = setViewFieldText(R.string.recycler_title, modelData.price_usd)
        binding.cryptoVolume.text = setViewFieldText(R.string.recycler_volume, modelData.volume24)
        binding.cryptoPercentChange24.text =
            setViewFieldText(R.string.recycler_percent_change_24, modelData.percent_change_24h)
    }

    private fun setViewFieldText(stringResources: Int, modelField: Any): String {
        return binding.root.context.getString(stringResources).plus(EMPTY_STRING).plus(modelField)
    }

    companion object {
        const val EMPTY_STRING = " "
    }
}