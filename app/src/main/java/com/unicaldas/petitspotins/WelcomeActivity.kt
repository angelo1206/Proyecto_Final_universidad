package com.unicaldas.petitspotins

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView

class WelcomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        setSupportActionBar(findViewById(R.id.my_toolbar))


        val card_1 = findViewById<CardView>(R.id.card_pay)
        val card_2 = findViewById<CardView>(R.id.card_sale)
        val card_3 = findViewById<CardView>(R.id.card_home)
        val card_4 = findViewById<CardView>(R.id.card_article)
        val card_5 = findViewById<CardView>(R.id.card_list)
        val card_6 = findViewById<CardView>(R.id.card_gal)

        card_1.setOnClickListener(clickListener)
        card_2.setOnClickListener(clickListener)
        card_3.setOnClickListener(clickListener)
        card_4.setOnClickListener(clickListener)
        card_5.setOnClickListener(clickListener)
        card_6.setOnClickListener(clickListener)

    }

//    ONCLICK PARA LA PRIMERA CARD

    val clickListener = View.OnClickListener {view ->

        when (view.getId()) {
            R.id.card_pay-> irPago()
            R.id.card_sale-> irVenta()
            R.id.card_home-> irHome()
            R.id.card_article-> irArticulo()
            R.id.card_list-> irLista()
            R.id.card_gal-> irGallery()



        }
    }

    private fun irPago() {
        val intento = Intent(this, AbonoActivity::class.java)
        startActivity(intento)
    }

    private fun irVenta() {
        val intento = Intent(this, VentaActivity::class.java)
        startActivity(intento)
    }

    private fun irHome() {
        val intento = Intent(this, HomeActivity::class.java)
        startActivity(intento)
    }

    private fun irArticulo() {
        val intento = Intent(this, ArticuloActivity::class.java)
        startActivity(intento)
    }

    private fun irLista() {
        val intento = Intent(this, RegistroActivity::class.java)
        startActivity(intento)
    }

    private fun irGallery() {
        val intento = Intent(this, GalleryActivity::class.java)
        startActivity(intento)
    }


}