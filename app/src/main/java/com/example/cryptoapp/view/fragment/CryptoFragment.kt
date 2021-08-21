package com.example.cryptoapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.CryptoFragmentBinding
import com.example.cryptoapp.view.recyclerview.CryptoAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

class CryptoFragment : Fragment(), KoinComponent {

    private val viewModel by viewModel<CryptoViewModel>()
    private lateinit var binding: CryptoFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.crypto_fragment, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSpinner()
    }

    private fun createAdapter(){
        val adapter = CryptoAdapter(
        )
        binding.cryptoRecyclerView.adapter = adapter
    }

    private fun initAdapter(){

    }

    private fun initSpinner() {
        binding.cryptoFilterSpinner.adapter =
            ArrayAdapter(
                binding.root.context,
                android.R.layout.simple_spinner_item,
                resources.getStringArray(R.array.spinner_content)
            )
        binding.cryptoFilterSpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> {
                    }
                    1 -> {
                    }
                    2 -> {
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //do nothing
            }

        }
    }

}