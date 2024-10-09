package com.wcsm.currencyexchangemvvm.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.wcsm.currencyexchangemvvm.data.getCurrencies
import com.wcsm.currencyexchangemvvm.databinding.CurrencyItemBinding
import com.wcsm.currencyexchangemvvm.model.Currency

class CurrencyAdapter(
    resources: Resources
) : Adapter<CurrencyAdapter.CurrencyViewHolder>() {
    private val currencies = getCurrencies(resources)

    inner class CurrencyViewHolder(
        private val binding: CurrencyItemBinding
    ) : ViewHolder(binding.root) {
        fun bind(currency: Currency) {
            binding.tvCode.text = currency.code
            binding.tvName.text = currency.name
            binding.tvCountry.text = currency.country
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CurrencyItemBinding.inflate(layoutInflater, parent, false)
        return CurrencyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currency = currencies[position]
        holder.bind(currency)
    }

    override fun getItemCount(): Int {
        return currencies.size
    }

}