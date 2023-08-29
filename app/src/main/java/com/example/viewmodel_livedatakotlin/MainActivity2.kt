package com.example.viewmodel_livedatakotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.viewmodel_livedatakotlin.databinding.ActivityMain2Binding
import com.example.viewmodel_livedatakotlin.viewModelLiveData.cargarImagen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private var context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPizza.setOnClickListener { traerDatos() }
    }

    fun traerDatos() {
        CoroutineScope(Dispatchers.Main).launch {
            val apiProducto: ConsumirApi =
                RetrofitClient.getRetrofit().create(ConsumirApi::class.java)
            val result = apiProducto.getTraer()
            when {
                result.isSuccessful -> {
                    val miprod = result.body()
                    miprod?.let { cargarEnPantalla(it.producto) }
                }
                result.code() == 401 -> {
                    Log.d("Seba", result.message())
                }
                else -> {
                    Log.d("Seba", "Error..")
                }
            }
        }
    }

    private fun cargarEnPantalla(miprod: Producto.Producto) {
        with(binding) {
            tvDescription.text = miprod.descripcion
            tvPrecio.text = miprod.precio.toString()
            cargarImagen(miprod.image, context, imageView)
        }
    }
}