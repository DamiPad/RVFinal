package com.example.reservaciondevuelos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.util.*

@Entity(tableName = "vuelos")

data class ClaseVuelos(
    @ColumnInfo(name = "nombre")
    var pasajeronombre:String,
    @ColumnInfo(name = "telefono")
    var pasajerotelefono:String,
    @ColumnInfo(name = "precio")
    var precioboleto:String,
    @ColumnInfo(name = "pago")
    var formapago:String,
    @ColumnInfo(name = "codigo")
    var codigovuelo:String,
    @ColumnInfo(name = "nvuelo")
    var numerovuelo:String,
    @ColumnInfo(name = "asiento")
    var numeroasiento:String,
    @ColumnInfo(name = "origen")
    var origen:String,
    @ColumnInfo(name = "destino")
    var destino:String
){
@PrimaryKey(autoGenerate = true)
@ColumnInfo(name = "id")@NotNull var id:Int=0}