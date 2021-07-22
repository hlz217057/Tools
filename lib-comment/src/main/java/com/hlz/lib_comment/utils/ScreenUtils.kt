package com.hlz.lib_comment.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.annotation.RequiresApi
import com.hlz.lib_comment.App

object ScreenUtils {

//    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @SuppressLint("NewApi")
    fun getScreenWidth(): Int {
        val windowManager = App.app.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        if (windowManager != null) {
            val outMetrics = DisplayMetrics()
//            windowManager.getDefaultDisplay().getMetrics(outMetrics)//显示部分
            windowManager.getDefaultDisplay().getRealMetrics(outMetrics)//显示部分 + 系统装饰
            val widthPixels = outMetrics.widthPixels //可用显示大小的绝对宽度（以像素为单位）。
            val heightPixels = outMetrics.heightPixels //可用显示大小的绝对高度（以像素为单位）。
            val densityDpi = outMetrics.densityDpi //屏幕密度表示为每英寸点数。
            val density = outMetrics.density //显示器的逻辑密度。
            val scaledDensity = outMetrics.scaledDensity //显示屏上显示的字体缩放系数。
            return widthPixels
        }
        return 0
    }

//    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @SuppressLint("NewApi")
    fun getScreenHeight(): Int {
        val windowManager = App.app.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        if (windowManager != null) {
            val outMetrics = DisplayMetrics()
//            windowManager.getDefaultDisplay().getMetrics(outMetrics)//显示部分
            windowManager.getDefaultDisplay().getRealMetrics(outMetrics)//显示部分 + 系统装饰
            val widthPixels = outMetrics.widthPixels //可用显示大小的绝对宽度（以像素为单位）。
            val heightPixels = outMetrics.heightPixels //可用显示大小的绝对高度（以像素为单位）。
            val densityDpi = outMetrics.densityDpi //屏幕密度表示为每英寸点数。
            val density = outMetrics.density //显示器的逻辑密度。
            val scaledDensity = outMetrics.scaledDensity //显示屏上显示的字体缩放系数。
            return heightPixels
        }
        return 0
    }
}