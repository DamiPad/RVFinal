package com.example.reservaciondevuelos

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_detalles.*
import kotlinx.android.synthetic.main.contenido_vuelos.view.*
import kotlinx.android.synthetic.main.vuelos_registro.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetallesVuelo : AppCompatActivity() {

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
        setContentView(R.layout.activity_detalles)

        /* db = VuelosBaseDatos.getAPPDataBase(this)
       doAsync {
           val adapter=VuelosAdapter(db!!.VuelosDAO().getDetalles(nombre))
           idrecyclerView.adapter=adapter


       }*/

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

        tvuno.text=nombre
        tvdos.text=telefono
        tvtres.text=precio
        tvcuatro.text=pago
        tvcinco.text=codigo
        tvseis.text=numerov
        tvsiete.text=numeroa
        tvocho.text=origen
        tvnueve.text=destino

        //ACTION_DIAL: abre la aplicación de teléfono o marcador.
        //ACTION_CALL: inicia una llamada telefónica (requiere el permiso CALL_PHONE).

        btnllamar.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$telefono")
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }

        }





    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menuabc,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var fragment: Boolean = true
        //idrecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        return when (item.itemId) {
            R.id.idInsertar -> {
                val intent = Intent(this, Registro::class.java)
                startActivity(intent)
                true
            }
            R.id.idActualizar -> {
                val intent = Intent(this, Actualizar::class.java)
                intent.putExtra("nombre",nombre)
                intent.putExtra("telefono",telefono)
                intent.putExtra("precio",precio)
                intent.putExtra("pago",pago)
                intent.putExtra("codigo",codigo)
                intent.putExtra("numerov",numerov)
                intent.putExtra("numeroa",numeroa)
                intent.putExtra("origen",origen)
                intent.putExtra("destino",destino)
                startActivity(intent)


                true
            }

            R.id.idEliminar -> {




                db = VuelosBaseDatos.getAPPDataBase(this)
                doAsync {
                    db?.VuelosDAO()?.deleteByNombre(nombre)

                    //val adapter=VuelosAdapter(db!!.VuelosDAO().getallVuelos())
                    //idrecyclerView.adapter=adapter
                }
                val intent = Intent(this, VuelosRegistro::class.java)
                startActivity(intent)



               true

            }
            else -> super.onOptionsItemSelected(item)

        }

    }
}

