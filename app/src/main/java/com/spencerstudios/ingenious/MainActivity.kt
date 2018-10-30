package com.spencerstudios.ingenious

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        tv.text = Bank(this).getBalance()

        fab_add.setOnClickListener { transactionDialog(this, true, tv) }
        fab_sub.setOnClickListener{ transactionDialog(this, false, tv) }
    }
}
