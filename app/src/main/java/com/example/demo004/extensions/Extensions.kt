package com.example.demo004.extensions

import android.widget.ImageView
import com.example.demo004.R
import com.squareup.picasso.Picasso

fun ImageView.imageUrl(url: String, placeholder: Int = R.mipmap.ic_launcher){
    Picasso.get()
        .load(url)
        .placeholder(placeholder)
        .into(this)
}
