package com.hlz.lib_comment.glide

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object GlideUtils {


    fun load(
        imageView: ImageView, url: Any, placeholder: Int = 0, error: Int = 0,
        round: Float = 0f, w: Int = 0, h: Int = 0
    ) {
        if (imageView == null) return
        val options = RequestOptions()
        options.placeholder(placeholder)
        options.error(error)
        options.transform()
        if (w != 0 || h != 0) {
            options.override(w, h)
        }
        Glide.with(imageView).setDefaultRequestOptions(options)
            .load(url)
            .centerCrop()
            .into(imageView)
    }
}