package com.macaulish.top.velvet.util

import android.util.Log

/**
 * created by hu
 * at 2018/7/8
 * in project salmon
 * description 封装[android.util.Log]日志工具
 */
object Logger {
    private const val DEFAULT_TAG = "salmon"

    /**
     * 使用默认Tag[DEFAULT_TAG]来输出info日志
     */
    fun i(msg: String) {
        Log.i(DEFAULT_TAG, msg)
    }

    /**
     * 使用指定的Tag[tag],为null时使用默认的Tag[DEFAULT_TAG]来输出info日志
     */
    fun i(tag: String?, msg: String) {
        Log.i(tag ?: DEFAULT_TAG, msg)
    }

    /**
     * 使用默认Tag[DEFAULT_TAG]来输出debug日志
     */
    fun d(msg: String) {
        Log.d(DEFAULT_TAG, msg)
    }

    /**
     * 使用指定的Tag[tag],为null时使用默认的Tag[DEFAULT_TAG]来输出debug日志
     */
    fun d(tag: String?, msg: String) {
        Log.d(tag ?: DEFAULT_TAG, msg)
    }
}