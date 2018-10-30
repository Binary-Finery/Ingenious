package com.spencerstudios.ingenious

import android.content.Context
import android.preference.PreferenceManager
import java.math.BigDecimal

class Bank(ctx: Context) {

    private val bank = PreferenceManager.getDefaultSharedPreferences(ctx)
    private val bankKey = "balance"
    private val startAmount = "0.00"

    fun getBalance(): String {
        return bank.getString(bankKey, startAmount)
    }

    fun setBalance(amt: BigDecimal) {
        bank.edit().putString(bankKey, amt.toString()).apply()
    }
}