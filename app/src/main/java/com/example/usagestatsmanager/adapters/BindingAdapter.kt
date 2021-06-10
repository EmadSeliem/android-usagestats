package com.example.usagestatsmanager.adapters

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("ImgSrc")
    fun setImageUrl(imageView: ImageView, placeHolder: Drawable?) {
        imageView.setImageDrawable(placeHolder);
    }

}