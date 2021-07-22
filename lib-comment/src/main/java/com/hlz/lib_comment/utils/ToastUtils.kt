package com.hlz.lib_comment.utils

import android.widget.Toast
import com.hlz.lib_comment.App

object ToastUtils {

    fun showToast(text: String?) {
        if (text.isNullOrEmpty()) return
        Toast.makeText(App.app, text, Toast.LENGTH_SHORT).show()
    }
}