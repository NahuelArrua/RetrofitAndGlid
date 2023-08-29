package com.example.viewmodel_livedatakotlin.viewModelLiveData

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

fun cargarImagen(url: String, context: Context, image: ImageView) {

    Glide
        .with(context)
        .load(url)
        .centerCrop()
        .into(image);
}