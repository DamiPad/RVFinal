package com.example.reservaciondevuelos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CargarAcercade : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aplicandofragment)

        val fragmentoacerca =FragmentAcercade()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.cambiar,fragmentoacerca)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
