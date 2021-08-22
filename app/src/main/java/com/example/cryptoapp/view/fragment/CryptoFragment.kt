package com.example.cryptoapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Transformations
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.CryptoFragmentBinding
import com.example.cryptoapp.model.CryptoDetailsModel
import com.example.cryptoapp.view.recyclerview.CryptoAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent
import java.util.*
import kotlin.Comparator

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
        initRecyclerView()
    }

    private fun initRecyclerView() {
        viewModel.cryptoList.observe(viewLifecycleOwner, {
            viewModel.isLoading.value = true
            createAdapter(it)
            createRecyclerLayout()
            viewModel.isLoading.value = false
        })
    }

    private fun createAdapter(model: List<CryptoDetailsModel>) {
        val adapter = CryptoAdapter(model)
        adapter.notifyDataSetChanged()
        binding.cryptoRecyclerView.adapter = adapter
    }

    private fun createRecyclerLayout() {
        binding.cryptoRecyclerView.layoutManager =
            GridLayoutManager(binding.root.context, SPAN_COUNT)
    }

    private fun initSpinner() {
        val adapter = ArrayAdapter(
            binding.root.context,
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.spinner_content)
        )
        binding.cryptoFilterSpinner.adapter = adapter
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
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
                        viewModel.cryptoList.value?.sortedBy { it -> it.name }?.let { it1 ->
                            createAdapter(
                                it1
                            )
                        }
                    }
                    1 -> {
                        viewModel.cryptoList.value?.sortedBy { it -> it.volume24 }?.let { it1 ->
                            createAdapter(
                                it1
                            )
                        }
                    }
                    2 -> {
                        viewModel.cryptoList.value?.sortedBy { it -> it.percent_change_24h }
                            ?.let { it1 ->
                                createAdapter(
                                    it1
                                )
                            }
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //do nothing
            }

        }
    }

    companion object {

        const val SPAN_COUNT = 2
    }
}