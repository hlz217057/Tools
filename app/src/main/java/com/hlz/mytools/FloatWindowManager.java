package com.hlz.mytools;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Build;
import android.provider.Settings;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import static android.content.Context.WINDOW_SERVICE;


public class FloatWindowManager {
    private volatile static FloatWindowManager instance = null;
    private Activity mAct;
    private WindowManager windowManager;
    private WindowManager.LayoutParams layoutParams;
    private View view;


    private FloatWindowManager(Activity activity) {
        this.mAct = activity;
        init(mAct);
    }

    private void init(Activity activity) {
        windowManager = (WindowManager) activity.getSystemService(WINDOW_SERVICE);
        layoutParams = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
//            layoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
            layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        }
        layoutParams.format = PixelFormat.RGBA_8888;
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.alpha = 0.5f;
//        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        layoutParams.flags =
                //不影响悬浮覆盖的view所以事件，单纯的是个盖板，就像护眼宝一样
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |

                //屏幕不限制   高度layoutParams.height = 5000超过手机屏幕高度都可
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;

//        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
//                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
//                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH |
//
//                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
//                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;

        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT+5000;
    }

    public static FloatWindowManager getInstance(Activity mAct) {
        if (instance == null) {
            synchronized (FloatWindowManager.class) {
                if (instance == null) {
                    instance = new FloatWindowManager(mAct);
                }
            }
        }
        return instance;

    }



    @SuppressLint("NewApi")
    public void showFloatingWindow() {
        if (Settings.canDrawOverlays(mAct)) {
            view = new View(mAct.getApplicationContext());
            view.setBackgroundColor(Color.BLACK);
            windowManager.addView(view, layoutParams);
        }
    }

    public void hideFloatingWindow() {
        if (null != view && windowManager != null) {
            windowManager.removeViewImmediate(view);
        }

    }
}
