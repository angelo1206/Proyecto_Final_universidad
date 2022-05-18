package com.unicaldas.petitspotins

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inicio = findViewById<ImageView>(R.id.inicio)

        inicio.setOnClickListener(clickListener)



    }

    val clickListener = View.OnClickListener {view ->

        when (view.getId()) {
            R.id.inicio-> irlogin()




        }
    }

    private fun irlogin() {
        val intento = Intent(this, LoginActivity::class.java)
        startActivity(intento)
    }


}