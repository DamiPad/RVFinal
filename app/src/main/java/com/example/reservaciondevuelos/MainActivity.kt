package com.example.reservaciondevuelos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private  var nombre ="Laura"
    private  var contrasena= "IniciarApp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEntrar.setOnClickListener {


            var etusuario= idUsuario.text.toString()
            var etpassword = idPassword.text.toString()

            if (etusuario == nombre && etpassword == contrasena){

                Toast.makeText(this, "Iniciando APP", Toast.LENGTH_LONG).show()
                val intent = Intent(this, Registro::class.java)
                startActivity(intent)

            } else{
                Toast.makeText(this, "Usuario y Password incorrectos", Toast.LENGTH_LONG).show()
            }

        }



    }
}
