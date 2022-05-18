package com.unicaldas.petitspotins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AbonoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abono)
        setSupportActionBar(findViewById(R.id.my_toolbar))
    }
}