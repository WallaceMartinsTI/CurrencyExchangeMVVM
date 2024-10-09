package com.wcsm.currencyexchangemvvm.data

import android.content.res.Resources
import com.wcsm.currencyexchangemvvm.R
import com.wcsm.currencyexchangemvvm.model.Currency

fun getCurrencies(resources: Resources): List<Currency> {
    return listOf(
        Currency(
            code = resources.getString(R.string.AED_CURRENCY_CODE),
            name = resources.getString(R.string.AED_CURRENCY_NAME),
            country = resources.getString(R.string.AED_CURRENCY_COUNTRY)
        ),
        Currency(
            code = resources.getString(R.string.ARS_CURRENCY_CODE),
            name = resources.getString(R.string.ARS_CURRENCY_NAME),
            country = resources.getString(R.string.ARS_CURRENCY_COUNTRY)
        ),
        Currency(
            code = resources.getString(R.string.AUD_CURRENCY_CODE),
            name = resources.getString(R.string.AUD_CURRENCY_NAME),
            country = resources.getString(R.string.AUD_CURRENCY_COUNTRY)
        ),
        Currency(
            code = resources.getString(R.string.BRL_CURRENCY_CODE),
            name = resources.getString(R.string.BRL_CURRENCY_NAME),
            country = resources.getString(R.string.BRL_CURRENCY_COUNTRY)
        ),
        Currency(
            code = resources.getString(R.string.CAD_CURRENCY_CODE),
            name = resources.getString(R.string.CAD_CURRENCY_NAME),
            country = resources.getString(R.string.CAD_CURRENCY_COUNTRY)
        ),
        Currency(
            code = resources.getString(R.string.CNY_CURRENCY_CODE),
            name = resources.getString(R.string.CNY_CURRENCY_NAME),
            country = resources.getString(R.string.CNY_CURRENCY_COUNTRY)
        ),
        Currency(
            code = resources.getString(R.string.EGP_CURRENCY_CODE),
            name = resources.getString(R.string.EGP_CURRENCY_NAME),
            country = resources.getString(R.string.EGP_CURRENCY_COUNTRY)
        ),
        Currency(
            code = resources.getString(R.string.GBP_CURRENCY_CODE),
            name = resources.getString(R.string.GBP_CURRENCY_NAME),
            country = resources.getString(R.string.GBP_CURRENCY_COUNTRY)
        ),
        Currency(
            code = resources.getString(R.string.JPY_CURRENCY_CODE),
            name = resources.getString(R.string.JPY_CURRENCY_NAME),
            country = resources.getString(R.string.JPY_CURRENCY_COUNTRY)
        ),
        Currency(
            code = resources.getString(R.string.NZD_CURRENCY_CODE),
            name = resources.getString(R.string.NZD_CURRENCY_NAME),
            country = resources.getString(R.string.NZD_CURRENCY_COUNTRY)
        ),
        Currency(
            code = resources.getString(R.string.THB_CURRENCY_CODE),
            name = resources.getString(R.string.THB_CURRENCY_NAME),
            country = resources.getString(R.string.THB_CURRENCY_COUNTRY)
        ),
        Currency(
            code = resources.getString(R.string.UAH_CURRENCY_CODE),
            name = resources.getString(R.string.UAH_CURRENCY_NAME),
            country = resources.getString(R.string.UAH_CURRENCY_COUNTRY)
        ),
        Currency(
            code = resources.getString(R.string.USD_CURRENCY_CODE),
            name = resources.getString(R.string.USD_CURRENCY_NAME),
            country = resources.getString(R.string.USD_CURRENCY_COUNTRY)
        ),
        Currency(
            code = resources.getString(R.string.YER_CURRENCY_CODE),
            name = resources.getString(R.string.YER_CURRENCY_NAME),
            country = resources.getString(R.string.YER_CURRENCY_COUNTRY)
        ),
    )
}