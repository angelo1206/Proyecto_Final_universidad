package com.unicaldas.petitspotins

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView

class LoginActivity : AppCompatActivity() {
    private var edtUsername : EditText? = null
    private var edtPassword : EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)

        val button = findViewById<Button>(R.id.button)


        button.setOnClickListener(clickListener)




    }

    val clickListener = View.OnClickListener {view ->

        when (view.getId()) {
            R.id.button-> irwelcome()




        }
    }

    private fun irwelcome() {
        var username:String = edtUsername!!.text.toString()
        var password:String = edtPassword!!.text.toString()

        if (username == "johan@gmail.com" && password == "1234"){



            //TERCERA FORMA DE INGRESO CON UN DIALOGO EMERGENTE PERO QUE NO QUITA FUNCIONALIDAD

            val intento = Intent(this,WelcomeActivity::class.java)
            startActivity(intento)

            Toast.makeText(applicationContext,getResources().getString(R.string.txt_welcome)+"!",
                Toast.LENGTH_LONG).show()



        }
        else{



            //SEGUNDA FORMA DE INVALIDAR EL USUARIO
            Toast.makeText(this,getResources().getString(R.string.txt_error_inicio), Toast.LENGTH_SHORT).show()
        }
    }



    /*fun onLogin(botonLogin: View) {


        var username:String = edtUsername!!.text.toString()
        var password:String = edtPassword!!.text.toString()

        if (username == "johan@gmail.com" && password == "1234"){



            //TERCERA FORMA DE INGRESO CON UN DIALOGO EMERGENTE PERO QUE NO QUITA FUNCIONALIDAD

            val intento = Intent(this,WelcomeActivity::class.java)
            startActivity(intento)

            Toast.makeText(applicationContext,getResources().getString(R.string.txt_welcome)+"!",
                Toast.LENGTH_LONG).show()



        }
        else{



            //SEGUNDA FORMA DE INVALIDAR EL USUARIO
            Toast.makeText(this,getResources().getString(R.string.txt_error_inicio), Toast.LENGTH_SHORT).show()
        }

    }*/


}









