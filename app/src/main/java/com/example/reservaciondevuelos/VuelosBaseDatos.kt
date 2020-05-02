package com.example.reservaciondevuelos

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import org.jetbrains.anko.AnkoAsyncContext

@Database(entities = arrayOf(ClaseVuelos::class), version = 1)


abstract class VuelosBaseDatos: RoomDatabase() {
    abstract fun VuelosDAO():VuelosDAO
    companion object{
        var INSTANCE: VuelosBaseDatos?=null
        fun getAPPDataBase(context: Context):VuelosBaseDatos? {
            if(INSTANCE == null)
            {
                synchronized(VuelosBaseDatos::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, VuelosBaseDatos::class.java,"vuelosbd").build()

                }
            }
            return INSTANCE
        }
    }
}