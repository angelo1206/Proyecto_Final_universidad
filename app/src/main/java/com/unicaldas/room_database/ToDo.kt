package com.unicaldas.room_database

import androidx.room.*

@Entity
data class ToDo (

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val codigo_venta: String,
    val fecha_venta : String,
    val cc_vendedor : String,
    val nombre_cliente: String,
    val cc_cliente : String,
    val direccion : String,
    val longitud : Float,
    val latitud : Float,
    val tipo_articulo : String,
    val largo : Float,
    val ancho : Float

)



