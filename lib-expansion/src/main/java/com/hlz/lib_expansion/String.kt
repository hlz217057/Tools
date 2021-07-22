package com.hlz.lib_expansion

import android.text.Html
import android.text.Spanned


//todo lengthV2
fun String.lengthV2(): Int {
    if (this.isNullOrEmpty()) return 0
    return this.length
}

//todo textV2
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
fun String.fromHtmlV2(): Spanned {
    if (this.isNullOrEmpty()) ""
    return Html.fromHtml(this)
}