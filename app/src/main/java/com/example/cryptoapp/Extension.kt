package com.example.cryptoapp

import android.widget.ImageView

// just example
fun ImageView.comparePercentChanges(pricePercent: String) {
    pricePercent.toDouble().let {
        when {
            it < 0 -> {
                this.setImageResource(R.drawable.ic_decrease_graph)
            }
            it > 0 -> {
                this.setImageResource(R.drawable.ic_increase_graph)
            }
        }
    }
}