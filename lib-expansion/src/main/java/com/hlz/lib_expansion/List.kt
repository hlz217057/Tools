package com.hlz.lib_expansion

import android.util.Log
import com.google.gson.Gson

private const val TAG = "List"

inline fun <T> ArrayList<T>.sizeV2(): Int {
    if (this.isNullOrEmpty()) return 0
    return this.size
}

fun <T> ArrayList<T>.removeV2(position: Int) {
    if (this.isNullOrEmpty()) return
    if (position >= this.size) return
    this.removeAt(position)
}

fun <T> ArrayList<T>.logi() {
    if (!isOpenLog)return
    Log.i(TAG, "logi: --------list 开始打印 ---------")
    if (this.isNullOrEmpty()){
        Log.i(TAG, "logi: --------list = null ---------")
        Log.i(TAG, "logi: --------list 结束打印 ---------")
        return
    }
    for (i in this.indices){
        Log.i(TAG, "logi: ----------start----------index: "+i)
        Log.i(TAG, "logi: -----------------------data: "+Gson().toJson(this[i]))
        Log.i(TAG, "logi: ----------end------------index: "+i)
    }
    Log.i(TAG, "logi: --------list 结束打印 ---------")
}

fun <T> ArrayList<T>.loge() {
    if (!isOpenLog)return
    Log.e(TAG, "loge: --------list 开始打印 ---------")
    if (this.isNullOrEmpty()){
        Log.e(TAG, "loge: --------list = null ---------")
        Log.e(TAG, "loge: --------list 结束打印 ---------")
        return
    }
    for (i in this.indices){
        Log.e(TAG, "loge: ----------start----------index: "+i)
        Log.e(TAG, "loge: -----------------------data: "+Gson().toJson(this[i]))
        Log.e(TAG, "loge: ----------end------------index: "+i)
    }
    Log.e(TAG, "loge: --------list 结束打印 ---------")
}


