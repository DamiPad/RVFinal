package com.example.reservaciondevuelos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.vuelos_registro.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class VuelosRegistro : AppCompatActivity() {

    private var db: VuelosBaseDatos?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vuelos_registro)


        idrecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //val datos =ArrayList<ClaseVuelos>()
        //val adapter=VuelosAdapter(datos,context = Context)
        //idrecyclerView.adapter=adapter

        db = VuelosBaseDatos.getAPPDataBase(this)
        doAsync {

          //  var datos = db?.VuelosDAO()?.getallVuelos()
                val adapter=VuelosAdapter(db!!.VuelosDAO().getallVuelos())
                idrecyclerView.adapter=adapter


        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var fragment : Boolean = true
        return when (item.itemId){
            R.id.idRegistro-> {
                val intent = Intent(this, Registro::class.java)
                startActivity(intent)
                true
            }
            R.id.idacercade-> {
                val intent = Intent(this, CargarAcercade::class.java)
                startActivity(intent)

                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }
}
