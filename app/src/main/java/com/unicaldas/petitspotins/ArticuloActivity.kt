package com.unicaldas.petitspotins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ArticuloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articulo)
        setSupportActionBar(findViewById(R.id.my_toolbar))
    }
}