package com.bjx.bjxcommon.extentions

import android.content.Context
import android.text.Html
import android.util.Log
import android.widget.Toast
import com.hlz.lib_expansion.isOpenLog

/**
 *防空
 *防越界
 */
private const val TAG = "String"


//todo lengthV2 获取字符长度
fun String?.lengthV2(): Int {
    if (this.isNullOrEmpty()) return 0
    return this.length
}

//todo textV2 获取文本
fun String?.text(): String {
    if (this.isNullOrEmpty()) return ""
    return this
}
//todo textV2 获取文本
fun String?.textInt(defNum: Int = 0): String {
    if (this.isNullOrEmpty()) return defNum.toString()
    return this
}

//todo substringV2 截取字符
fun String?.substringV2(startIndex: Int, endIndex: Int): String {
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

//todo fromHtmlV2 字符转html
fun String?.fromHtmlV2(): CharSequence {
    if (this.isNullOrEmpty()) return ""
    return Html.fromHtml(this)
}

//todo fontColor color = #4599F7
fun String?.fontColor(color: String): String {
    if (this.isNullOrEmpty()) return ""
    return "<font color='${color}'>${this}</font>"
}

//todo fontColorFromHtml color = #4599F7
fun String?.fontColorFromHtml(color: String): CharSequence {
    if (this.isNullOrEmpty()) return ""
    return this.fontColor(color).fromHtmlV2()
}

//todo logi 打印
fun String?.logi() {
    if (!isOpenLog) return
    Log.i(TAG, "logi: -------------打印开始----------")
    if (this.isNullOrEmpty()) {
        Log.i(TAG, "logi: ---------字符为空---------")
        Log.i(TAG, "logi: --------------打印结束---------")
        return
    }
    Log.i(TAG, "logi: ---------------data: " + this)
    Log.i(TAG, "logi: --------------打印结束---------")
}

//todo loge 打印
fun String?.loge() {
    if (!isOpenLog) return
    Log.e(TAG, "loge: -------------打印开始----------")
    if (this.isNullOrEmpty()) {
        Log.e(TAG, "loge: ---------字符为空---------")
        Log.e(TAG, "loge: --------------打印结束---------")
        return
    }
    Log.e(TAG, "loge: ---------------data: " + this)
    Log.e(TAG, "loge: --------------打印结束---------")
}

//todo showToast toast
fun String?.showToast(context: Context) {
    Toast.makeText(context, "" + this, Toast.LENGTH_SHORT).show()
}

//todo 限制最大个数
fun String?.maxLimit(size: Int): String {
    if (this.isNullOrEmpty()) return ""
    if (this.length > size) {
        return this.subSequence(0, size).toString() + "..."
    }
    return this
}

//todo 字符串连接 symbol连接符
fun stringForAppendSymbol(array: Array<String?>, symbol: String): String {
    if (array.isNullOrEmpty()) return ""
    val buffer = StringBuffer()
    for (item in array) {
        if (!item.isNullOrEmpty()) {
            buffer.append(item)
            buffer.append(symbol)
        }
    }
    val s = buffer.toString()
    if (!s.isNullOrEmpty()) {
        return s.substringV2(0, s.length - 1)
    }
    return ""
}


fun CharSequence?.toStringV2(defStr: String? = null): String? {
    if (this.isNullOrEmpty()) return defStr
    return this.toString()
}
fun CharSequence?.toStringNotNull(defStr: String = ""): String {
    if (this.isNullOrEmpty()) return defStr
    return this.toString()
}

fun CharSequence?.countV2(): Int {
    if (this.isNullOrEmpty()) return 0
    return this.length
}


fun getBegs(array: Array<String>,separator:String = " | "):String{
    val buffer = StringBuffer()
    for (m in array){
        if (!m.isNullOrEmpty()){
            buffer.append(m)
            buffer.append(separator)
        }
    }
    val s = buffer.toString()
    if (s.isNullOrEmpty())return ""
    return s.substring(0,s.length-separator.length)
}