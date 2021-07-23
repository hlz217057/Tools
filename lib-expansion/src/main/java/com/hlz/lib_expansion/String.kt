package com.hlz.lib_expansion

import android.text.Html
import android.util.Log

/**
 *防空
 *防越界
 */
private const val TAG = "String"


//todo lengthV2
fun String.lengthV2(): Int {
    if (this.isNullOrEmpty()) return 0
    return this.length
}

//todo textV2 防止文本为空
fun String.textV2(): String {
    if (this.isNullOrEmpty()) return ""
    return this
}

//todo substringV2
fun String.substringV2(startIndex: Int, endIndex: Int): String {
    if (this.isNullOrEmpty()) return ""
    var start = 0
    var end = endIndex
    if (startIndex > 0) {
        start = startIndex
    }
    if (endIndex > this.length) {
        end = this.length
    }
    return this.substring(start, end)
}

//todo fromHtmlV2
fun String.fromHtmlV2(): CharSequence {
    if (this.isNullOrEmpty()) return ""
    return Html.fromHtml(this)
}
//todo fontColor color = #4599F7
fun String.fontColor(color:String):String{
    if (this.isNullOrEmpty())return ""
    return "<font color='${color}'>${this}</font>"
}
//todo fontColorFromHtml color = #4599F7
fun String.fontColorFromHtml(color:String): CharSequence{
    if (this.isNullOrEmpty())return ""
    return this.fontColor(color).fromHtmlV2()
}
//todo logi
fun String.logi() {
    if (!isOpenLog) return
    Log.i(TAG, "logi: -------------打印开始----------")
    if (this.isNullOrEmpty()) {
        Log.i(TAG, "logi: ---------字符为空---------")
    }
    Log.i(TAG, "logi: ---------------data: " + this)
    Log.i(TAG, "logi: --------------打印结束---------")
}
//todo loge
fun String.loge() {
    if (!isOpenLog) return
    Log.e(TAG, "loge: -------------打印开始----------")
    if (this.isNullOrEmpty()) {
        Log.e(TAG, "loge: ---------字符为空---------")
    }
    Log.e(TAG, "loge: ---------------data: " + this)
    Log.e(TAG, "loge: --------------打印结束---------")
}