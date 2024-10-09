package com.wcsm.currencyexchangemvvm.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wcsm.currencyexchangemvvm.R
import com.wcsm.currencyexchangemvvm.adapter.CurrencyAdapter
import com.wcsm.currencyexchangemvvm.databinding.ActivityMainBinding
import com.wcsm.currencyexchangemvvm.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private lateinit var mainViewModel: MainViewModel
    private lateinit var currencyAdapter: CurrencyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.targetValue.isEnabled = false

        // Init Spinner
        initBaseCurrenciesSpinner()
        initTargetCurrenciesSpinner()

        // ViewModel
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // Observers
        mainViewModel.convertedValue.observe(this) { value ->
            binding.targetValue.setText("%.2f".format(value))
        }

        // RecyclerView - Adapters
        currencyAdapter = CurrencyAdapter(resources)
        binding.rvCurrencies.adapter = currencyAdapter
        binding.rvCurrencies.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )

        // Spinner Handler
        binding.baseCurrenciesSpinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent?.selectedItem.toString()
                if(selectedItem != "Select a currency") {
                    val currencyCode = selectedItem.substring(0, 3)
                    binding.tvBaseCode.text = currencyCode
                    mainViewModel.updateBaseCurrency(currencyCode)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) { }
        }

        binding.targetCurrenciesSpinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent?.selectedItem.toString()
                if(selectedItem != "Select a currency") {
                    val currencyCode = selectedItem.substring(0, 3)
                    binding.tvTargetCode.text = currencyCode
                    mainViewModel.updateTargetCurrency(currencyCode)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) { }
        }

        binding.btnConvert.setOnClickListener {
            val baseValue = binding.baseValueInput.text.toString().toDoubleOrNull()
            Log.i("#-# TESTE #-#", "baseValue: $baseValue")
            if(baseValue != null) {
                mainViewModel.getExchangeResponse(baseValue)
            }
        }
    }

    private fun initBaseCurrenciesSpinner() {
        val currencies = resources.getStringArray(R.array.currencies_array)
        binding.baseCurrenciesSpinner.adapter = ArrayAdapter(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            currencies
        )
    }

    private fun initTargetCurrenciesSpinner() {
        val currencies = resources.getStringArray(R.array.currencies_array)
        binding.targetCurrenciesSpinner.adapter = ArrayAdapter(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            currencies
        )
    }
}