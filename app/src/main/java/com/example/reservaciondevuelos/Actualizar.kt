package com.example.reservaciondevuelos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_actualizar.*
import kotlinx.android.synthetic.main.activity_registro.*
import org.jetbrains.anko.doAsync
//import sun.jvm.hotspot.utilities.IntArray


class Actualizar : AppCompatActivity() {
    lateinit var  pagoA: Spinner
    lateinit var  origenA: Spinner
    lateinit var  destinA: Spinner

    private var db: VuelosBaseDatos?=null

    var nombre = String()
    var telefono = String()
    var precio = String()
    var pago = String()
    var codigo = String()
    var numerov = String()
    var numeroa = String()
    var origen = String()
    var destino = String()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar)
        pagoA = findViewById(R.id.idFormaPagoA) as Spinner
        origenA = findViewById(R.id.idOrigenA) as Spinner
        destinA = findViewById(R.id.idDestinoA) as Spinner
        var cpago = String()
        var corigen = String()
        var cdestino = String()

        var intentD: Intent = intent
        nombre = intentD.getStringExtra("nombre")
        telefono = intentD.getStringExtra("telefono")
        precio = intentD.getStringExtra("precio")
        pago = intentD.getStringExtra("pago")
        codigo = intentD.getStringExtra("codigo")
        numerov = intentD.getStringExtra("numerov")
        numeroa = intentD.getStringExtra("numeroa")
        origen = intentD.getStringExtra("origen")
        destino = intentD.getStringExtra("destino")







        var pagos = arrayOf("Efectivo", "Tarjeta de Credito", "Paypal")
        var origenes = arrayOf(
            "Ciudad de Mexico",
            "Guadalajara",
            "Cancun",
            "Las Vegas",
            "Nueva York",
            "Madrid",
            "Francia",
            "Nueva Zelanda"
        )
        var destinos = arrayOf(
            "Ciudad de Mexico",
            "Guadalajara",
            "Cancun",
            "Las Vegas",
            "Nueva York",
            "Madrid",
            "Francia",
            "Nueva Zelanda"
        )

        pagoA.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pagos)
        origenA.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, origenes)
        destinA.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, destinos)


        idNombrePasajeroA.setText(nombre)
        idtelefonoA.setText(telefono)
        idPrecioBoletoA.setText(precio)
        idCodigoVueloA.setText(codigo)
        idNumVueloA.setText(numerov)
        idNumAsientoA.setText(numeroa)





        if (pagoA != null) {


            pagoA.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@Actualizar,
                        pagos[position], Toast.LENGTH_SHORT
                    ).show()
                    cpago = pagos[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        if (origenA != null) {


            origenA.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@Actualizar,
                        origenes[position], Toast.LENGTH_SHORT
                    ).show()
                    corigen = origenes[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        if (destinA != null) {


            destinA.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@Actualizar,
                        destinos[position], Toast.LENGTH_SHORT
                    ).show()
                    cdestino = destinos[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        val btn_actualiza = findViewById(R.id.btnActualizar) as Button
        // set on-click listener
        btn_actualiza.setOnClickListener {

            val pasajeronombre = idNombrePasajeroA.text.toString()
            val pasajerotelefono = idtelefonoA.text.toString()
            val precioboleto = idPrecioBoletoA.text.toString()
            val codigovuelo = idCodigoVueloA.text.toString()
            val numerovuelo = idNumVueloA.text.toString()
            val numeroasiento = idNumAsientoA.text.toString()



            db = VuelosBaseDatos.getAPPDataBase(this)
            doAsync{

                db?.VuelosDAO()?.updateVuelo(pasajeronombre,pasajerotelefono,precioboleto,cpago,codigovuelo,numerovuelo,numeroasiento,corigen,cdestino)


            }

            Toast.makeText(this, "Actualizado", Toast.LENGTH_LONG).show()
            val intent = Intent(this, VuelosRegistro::class.java)
            startActivity(intent)


        }




    }
}
