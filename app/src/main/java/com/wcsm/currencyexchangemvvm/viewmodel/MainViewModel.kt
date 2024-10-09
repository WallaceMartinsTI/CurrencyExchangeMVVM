package com.wcsm.currencyexchangemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wcsm.currencyexchangemvvm.api.ExchangeAPI
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val baseCurrency = MutableLiveData("Select a currency")
    val targetCurrency = MutableLiveData("Select a currency")

    val convertedValue = MutableLiveData(0.0)

    fun updateBaseCurrency(currency: String) {
        baseCurrency.value = currency
    }

    fun updateTargetCurrency(currency: String) {
        targetCurrency.value = currency
    }

    fun getExchangeResponse(value: Double) {
        if(baseCurrency.value != "Select a currency") {
            val exchangeAPI = ExchangeAPI()
            viewModelScope.launch {
                val baseValue = baseCurrency.value.toString()
                val targetValue = targetCurrency.value.toString()
                val result = exchangeAPI.getConvertedValue(baseValue, targetValue, value)
                convertedValue.postValue(result)
            }
        }
    }
}