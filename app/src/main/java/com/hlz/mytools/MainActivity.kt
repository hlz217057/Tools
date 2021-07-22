package com.hlz.mytools

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.widget.TextView
import com.hlz.lib_expansion.*


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

        findViewById<TextView>(R.id.tv).text = s.substringV2(2,3)
    }
}