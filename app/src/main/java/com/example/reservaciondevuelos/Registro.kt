package com.example.reservaciondevuelos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_registro.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
//import sun.jvm.hotspot.utilities.IntArray


class Registro : AppCompatActivity() {
    lateinit var  pago: Spinner
    lateinit var  origen: Spinner
    lateinit var  destin: Spinner

    private var db: VuelosBaseDatos?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        pago = findViewById(R.id.idFormaPago) as Spinner
        origen = findViewById(R.id.idOrigen) as Spinner
        destin = findViewById(R.id.idDestino) as Spinner
        var cpago = String()
        var corigen = String()
        var cdestino = String()

        var pagos = arrayOf("Efectivo","Tarjeta de Credito", "Paypal")
        var origenes = arrayOf("Ciudad de Mexico", "Guadalajara", "Cancun", "Las Vegas", "Nueva York", "Madrid", "Francia", "Nueva Zelanda")
        var destinos = arrayOf("Ciudad de Mexico", "Guadalajara", "Cancun", "Las Vegas", "Nueva York", "Madrid", "Francia", "Nueva Zelanda" )

        pago.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,pagos)
        origen.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,origenes)
        destin.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,destinos)


        //val mySpinner = findViewById(R.id.idFormaPago) as Spinner


        //val corigen = origen.selectedItem.toString()
        //val cdestino = destin.selectedItem.toString()


        if (pago != null) {


            pago.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(this@Registro,
                        pagos[position], Toast.LENGTH_SHORT).show()
                        cpago  = pagos[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        if (origen != null) {


            origen.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(this@Registro,
                        origenes[position], Toast.LENGTH_SHORT).show()
                        corigen  =origenes[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        if (destin != null) {


            destin.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(this@Registro,
                        destinos[position], Toast.LENGTH_SHORT).show()
                        cdestino  = destinos[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }




        val btn_click_me = findViewById(R.id.btnAgregar) as Button
        // set on-click listener
        btn_click_me.setOnClickListener {

            val pasajeronombre = idNombrePasajero.text.toString()
            val pasajerotelefono = idtelefono.text.toString()
            val precioboleto = idPrecioBoleto.text.toString()
            //val formapago= = idPrecioBoleto.text.toString()
            val codigovuelo = idCodigoVuelo.text.toString()
            val numerovuelo = idNumVuelo.text.toString()
            val numeroasiento = idNumAsiento.text.toString()
            //val origen = idNumAsiento.text.toString()
            //val destino = idNumAsiento.text.toString()

            val vuelitos = ClaseVuelos(pasajeronombre = pasajeronombre, pasajerotelefono= pasajerotelefono, precioboleto =  precioboleto, formapago = cpago, codigovuelo = codigovuelo, numerovuelo = numerovuelo, numeroasiento = numeroasiento, origen = corigen, destino= cdestino)

            db = VuelosBaseDatos.getAPPDataBase(this)
            doAsync{

                db?.VuelosDAO()?.insert(vuelitos)
                var hola = db?.VuelosDAO()?.getallVuelos()
                uiThread {
                    println("elementoooooooooooooooooooooooooooooosssssssssssss" + hola)
                }

            }

            Toast.makeText(this, "Registrado", Toast.LENGTH_LONG).show()
            val intent = Intent(this, VuelosRegistro::class.java)
            startActivity(intent)




        }
    }
}
