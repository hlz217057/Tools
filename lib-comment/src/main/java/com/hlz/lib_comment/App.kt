package com.hlz.lib_comment

import android.app.Application
import android.util.Log
import android.view.Choreographer
import java.util.concurrent.TimeUnit

class App : Application() {

    companion object {
        lateinit var app: App
    }

    override fun onCreate() {
        super.onCreate()
        app = this

        ui()
    }

    fun ui() {
        Choreographer.getInstance().postFrameCallback(object : Choreographer.FrameCallback {

            override fun doFrame(frameTimeNanos: Long) {
                var lastFrameTimeNanos = 0L
                var currentFrameTimeNanos = 0L

                if (lastFrameTimeNanos == 0L) {
                    lastFrameTimeNanos = frameTimeNanos
                }

                currentFrameTimeNanos = frameTimeNanos
                val diffMs = TimeUnit.MILLISECONDS.convert(
                    currentFrameTimeNanos - lastFrameTimeNanos,
                    TimeUnit.NANOSECONDS
                )
                if (diffMs > 16.6f) {

                    val droppedCount = diffMs / 16.6
                    Log.e("TAG", "发生丢帧: "+diffMs)
                }

                Choreographer.getInstance().postFrameCallback(this)
            }
        })
    }
}