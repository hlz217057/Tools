package com.hlz.lib_bugs

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.hlz.lib_comment.utils.ScreenUtils

/**

todo bus:1 java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState
 todo 解决方案： commitAllowingStateLoss()

 */


/**
 * todo DialogFragment bug
 */
class DialogFragmentBug {

    /**
    bus:1
    java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState
    解决方案：
    重写show方法
     */

}
abstract class BaseCenterFragmentDialog : DialogFragment() {
    var mRootView : View? = null

    private val TAG = "BaseBottomFragmentDialo"

    @SuppressLint("ResourceType")
    override fun onStart() {
        super.onStart()

        val window = dialog!!.window
        //设置位置在屏幕底部
        window!!.setGravity(Gravity.CENTER)
        //设置弹入弹出动画
//        window.setWindowAnimations(R.style.BottomDialogAnimation)
        window.setBackgroundDrawableResource(R.color.transparent)
        //设置为全屏dialog
        val params = window.attributes
        params.width = WindowManager.LayoutParams.MATCH_PARENT
        params.height = WindowManager.LayoutParams.WRAP_CONTENT
        window.attributes = params

        window.setLayout(setWidth(),setHeight())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = LayoutInflater.from(context).inflate(layout,container,false)
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //androidx 版本
    override fun show(manager: FragmentManager, tag: String?) {
//        super.show(manager, tag)
        try {
            val cls = Class.forName("androidx.fragment.app.DialogFragment")
            val dismissed = cls.getDeclaredField("mDismissed")
            dismissed.isAccessible = true
            val shownByMe = cls.getDeclaredField("mShownByMe")
            shownByMe.isAccessible = true
            dismissed.set(this, false)
            shownByMe.set(this, false)

            val ft = manager.beginTransaction()
            ft.add(this, tag)
            ft.commitAllowingStateLoss()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    protected abstract val layout: Int
    protected abstract fun initView()

    /**
     * todo 动态设置高度
     */
    open fun setHeight(): Int {
        return ScreenUtils.getScreenHeight() / 2
    }

    open fun setWidth(): Int {
        return ScreenUtils.getScreenWidth()
    }
}