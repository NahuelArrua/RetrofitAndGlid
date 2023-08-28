package com.example.viewmodel_livedatakotlin

import android.media.Image

data class Producto(
    val producto: Producto
) {
    data class Producto(
        val descripcion: String,
        val precio: Int,
        val image: String
    )
}