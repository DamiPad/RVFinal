package com.example.reservaciondevuelos

import androidx.room.*

@Dao
interface VuelosDAO {
    @Query("SELECT * FROM vuelos ORDER BY nombre")
    fun getallVuelos():List<ClaseVuelos>

    @Query("SELECT * FROM vuelos WHERE nombre = :pasajero")
    fun getDetalles(pasajero:String): ClaseVuelos

    @Insert
    fun insert(clasevuelos: ClaseVuelos)

    @Delete
    fun delete(clasevuelos: ClaseVuelos)

    @Query("DELETE FROM vuelos WHERE nombre = :nombre")
    fun deleteByNombre(nombre: String)

    @Update
    fun updateVuelo(clasevuelos: ClaseVuelos)

    @Query("UPDATE vuelos SET telefono = :telefono, precio = :precio, pago= :pago, codigo = :codigo, nvuelo = :nvuelo, asiento = :asiento, origen = :origen, destino = :destino WHERE nombre = :nombre")

    fun updateVuelo(nombre:String, telefono: String, precio: String, pago: String, codigo: String, nvuelo: String, asiento: String, origen: String, destino: String): Int
}





