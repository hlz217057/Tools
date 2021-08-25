package com.hlz.mytools

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.Gravity
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.hlz.lib_comment.easyphotos.GlideEngine
import com.hlz.lib_comment.utils.ToastUtils
import com.hlz.lib_expansion.*
import com.huantansheng.easyphotos.EasyPhotos
import com.huantansheng.easyphotos.engine.ImageEngine


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list = ArrayList<String>()
        val buffer = StringBuffer()
        buffer.append("处理前：\n")

        for (i in 0..10){
            list.add("pos:"+i+"\n")
        }

        for (m in list){
            buffer.append(m)
        }

        list.removeV2(1)
        list.removeV2(list.size-1)

        buffer.append("\n处理后：\n")
        for (m in list){
            buffer.append(m)
        }

        val s = "123456789"

        list.loge()

        findViewById<TextView>(R.id.tv).text = s
        findViewById<TextView>(R.id.tv).textSize = 100f
        findViewById<TextView>(R.id.tv).setOnClickListener {
            ToastUtils.showToast("cccccccccccc")
            EasyPhotos.createAlbum(this,true,true, GlideEngine.getInstance())
                .setCount(6)
                .setGif(true)
                .setVideo(true)
                .setFileProviderAuthority("fileprovider")
                .start(100)
        }


        show()
    }

    @SuppressLint("NewApi")
    private fun show() {
        if (!Settings.canDrawOverlays(this)) {
            val intent =  Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, 10);
            return
        }

        FloatWindowManager.getInstance(this)
            .showFloatingWindow()

//        val mWindowManager = this.applicationContext.getSystemService(WindowManager::class.java)
//        val tv = TextView(this)
//        tv.setBackgroundColor(Color.BLUE)
//        tv.setTextSize(50f)
//        tv.setTextColor(getColor(R.color.white))
//        val mLayoutParams = WindowManager.LayoutParams(
//            WindowManager.LayoutParams.MATCH_PARENT,
//            WindowManager.LayoutParams.WRAP_CONTENT
//        )
//        mLayoutParams.flags = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
//        mLayoutParams.gravity = Gravity.CENTER
//        mWindowManager.addView(tv,mLayoutParams)
    }

    override fun onPause() {
        super.onPause()
//        FloatWindowManager.getInstance(this).hideFloatingWindow()
    }

}