package com.example.reservaciondevuelos
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contenido_vuelos.view.*
import kotlinx.android.synthetic.main.vuelos_registro.view.*

class VuelosAdapter(val items:List<ClaseVuelos>): RecyclerView.Adapter<VuelosAdapter.ViewHolder>(){

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        fun bindItem(data:ClaseVuelos){
            itemView.tvnombre.text=data.pasajeronombre.toString()
            itemView.tvtelefono.text=data.pasajerotelefono.toString()
            itemView.tvprecio.text=data.precioboleto.toString()
            itemView.tvpago.text=data.formapago.toString()
            itemView.tvcodigo.text=data.codigovuelo.toString()
            itemView.tvvuelo.text=data.numerovuelo.toString()
            itemView.tvasiento.text=data.numeroasiento.toString()
            itemView.tvorigen.text=data.origen.toString()
            itemView.tvdestino.text=data.destino.toString()
            //itemView.tvtexto.text=data.nombre.toString()
            itemView.setOnClickListener{

                Toast.makeText(itemView.context,"Vuelo de ${data.pasajeronombre}", Toast.LENGTH_LONG).show()
                val intent = Intent(itemView.context, DetallesVuelo::class.java)
                intent.putExtra("nombre",data.pasajeronombre)
                intent.putExtra("telefono",data.pasajerotelefono)
                intent.putExtra("precio",data.precioboleto)
                intent.putExtra("pago",data.formapago)
                intent.putExtra("codigo",data.codigovuelo)
                intent.putExtra("numerov",data.numerovuelo)
                intent.putExtra("numeroa",data.numeroasiento)
                intent.putExtra("origen",data.origen)
                intent.putExtra("destino",data.destino)

                itemView.context.startActivity(intent)


            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.contenido_vuelos,parent,false
        ))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }
}