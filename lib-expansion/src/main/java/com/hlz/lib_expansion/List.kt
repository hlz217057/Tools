package com.hlz.lib_expansion

inline fun <T> ArrayList<T>.sizeV2(): Int {
    if (this.isNullOrEmpty()) return 0
    return this.size
}

fun <T> ArrayList<T>.removeV2(position: Int) {
    if (this.isNullOrEmpty()) return
    if (position >= this.size) return
    this.removeAt(position)
}

