package com.unicaldas.petitspotins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class VentaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venta)
        setSupportActionBar(findViewById(R.id.my_toolbar))
    }
}