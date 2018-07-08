package com.macaulish.top.velvet.util

import android.content.Context
import android.widget.Toast

/**
 * created by hu
 * at 2018/7/8
 * in project salmon
 * description 封装使用安卓提供的[android.widget.Toast]工具
 */
object Toaster {

    /**
     * Toast[message]信息,duration = [Toast.LENGTH_SHORT]
     */
    fun shortToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }


    /**
     * Toast[message]信息,duration = [Toast.LENGTH_LONG]
     */
    fun longToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}