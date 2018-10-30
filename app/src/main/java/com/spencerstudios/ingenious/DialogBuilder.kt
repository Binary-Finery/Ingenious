package com.spencerstudios.ingenious

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.TextView
import kotlinx.android.synthetic.main.transaction_amount_dialog.view.*
import java.math.BigDecimal

fun transactionDialog(ctx: Context, add: Boolean, tv: TextView) {
    val builder = AlertDialog.Builder(ctx).create()
    val view = LayoutInflater.from(ctx).inflate(R.layout.transaction_amount_dialog, null)
    view.btn_submit_dialog_confirm.setText(if (add) R.string.btn_dialog_add else R.string.btn_dialog_deduct)
    view.tv_sumbmit_dialog_title.setText(if (add) R.string.tv_dialog_add else R.string.tv_dialog_add)
    builder.setView(view)

    view.btn_submit_dialog_confirm.setOnClickListener {
        val inBank = BigDecimal.valueOf(Bank(ctx).getBalance().toDouble())
        val amt = BigDecimal.valueOf((view.et_hundreds.text.toString() + "." + view.et_units.text.toString()).toDouble())

        Bank(ctx).setBalance(if (add) inBank.add(amt) else inBank.subtract(amt))
        tv.text = Bank(ctx).getBalance()

        builder.dismiss()
    }
    builder.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
    builder.show()
}