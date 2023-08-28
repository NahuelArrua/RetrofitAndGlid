package com.example.viewmodel_livedatakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.viewmodel_livedatakotlin.databinding.ActivityMain2Binding
import retrofit2.Call
import retrofit2.Response


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitTraer = RetrofitClient.consumirApi.getTraer()

        binding.btnPizza.setOnClickListener {

            retrofitTraer.enqueue(object : retrofit2.Callback<Producto> {

                override fun onResponse(call: Call<Producto>, response: Response<Producto>) {
                    //binding.imageView2.load("f1672396-be27-493f-b525-a642deafdf62")
                    //binding.imageView.text = response.body()?.producto?.image.toString()

                    val url = "f1672396-be27-493f-b525-a642deafdf62"

                   Glide
                        .with(this@MainActivity2)
                        .load(url)
                        .fitCenter()
                        .into(binding.imageView)

                    binding.tvPrecio.text = response.body()?.producto?.precio.toString()
                    binding.tvDescription.text = response.body()?.producto?.descripcion.toString()

                }

                override fun onFailure(call: Call<Producto>, t: Throwable) {
                    Toast.makeText(
                        this@MainActivity2,
                        "error al consultar la api rest",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        }
    }
}