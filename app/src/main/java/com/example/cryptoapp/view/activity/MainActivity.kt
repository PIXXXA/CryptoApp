package com.example.cryptoapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cryptoapp.R
import com.example.cryptoapp.view.fragment.CryptoFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, CryptoFragment()).commit()
    }
}