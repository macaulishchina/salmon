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
    private const val MAX_LOGGER_LENGTH = 1024 * 3 //3KB

    /**
     * 使用默认Tag[DEFAULT_TAG]来输出Verbose日志
     */
    fun v(msg: String) {
        v(null, msg)
    }

    /**
     * 使用指定的Tag[tag],为null时使用默认的Tag[DEFAULT_TAG]来输出Verbose日志
     */
    fun v(tag: String?, msg: String) {
        val tg = tag ?: DEFAULT_TAG
        val divc = msg.length / MAX_LOGGER_LENGTH
        val tail = if (divc == 0) msg else "part ${divc + 1} of ${divc + 1} :" + msg.substring(MAX_LOGGER_LENGTH * divc, msg.length)
        for (i in 0 until divc) {
            Log.v(tg, "part ${i + 1} of ${divc + 1} :" + msg.substring(i * MAX_LOGGER_LENGTH, (i + 1) * MAX_LOGGER_LENGTH))
        }
        Log.v(tg, tail)
    }


    /**
     * 使用默认Tag[DEFAULT_TAG]来输出Debug日志
     */
    fun d(msg: String) {
        d(null, msg)
    }

    /**
     * 使用指定的Tag[tag],为null时使用默认的Tag[DEFAULT_TAG]来输出Debug日志
     */
    fun d(tag: String?, msg: String) {
        val tg = tag ?: DEFAULT_TAG
        val divc = msg.length / MAX_LOGGER_LENGTH
        val tail = if (divc == 0) msg else "part ${divc + 1} of ${divc + 1} :" + msg.substring(MAX_LOGGER_LENGTH * divc, msg.length)
        for (i in 0 until divc) {
            Log.d(tg, "part ${i + 1} of ${divc + 1} :" + msg.substring(i * MAX_LOGGER_LENGTH, (i + 1) * MAX_LOGGER_LENGTH))
        }
        Log.d(tg, tail)
    }

    /**
     * 使用默认Tag[DEFAULT_TAG]来输出Info日志
     */
    fun i(msg: String) {
        i(null, msg)
    }

    /**
     * 使用指定的Tag[tag],为null时使用默认的Tag[DEFAULT_TAG]来输出Info日志
     */
    fun i(tag: String?, msg: String) {
        val tg = tag ?: DEFAULT_TAG
        val divc = msg.length / MAX_LOGGER_LENGTH
        val tail = if (divc == 0) msg else "part ${divc + 1} of ${divc + 1} :" + msg.substring(MAX_LOGGER_LENGTH * divc, msg.length)
        for (i in 0 until divc) {
            Log.i(tg, "part ${i + 1} of ${divc + 1} :" + msg.substring(i * MAX_LOGGER_LENGTH, (i + 1) * MAX_LOGGER_LENGTH))
        }
        Log.i(tg, tail)
    }

    /**
     * 使用默认Tag[DEFAULT_TAG]来输出Error日志
     */
    fun e(msg: String) {
        e(null, msg)
    }

    /**
     * 使用指定的Tag[tag],为null时使用默认的Tag[DEFAULT_TAG]来输出Error日志
     */
    fun e(tag: String?, msg: String) {
        val tg = tag ?: DEFAULT_TAG
        val divc = msg.length / MAX_LOGGER_LENGTH
        val tail = if (divc == 0) msg else "part ${divc + 1} of ${divc + 1} :" + msg.substring(MAX_LOGGER_LENGTH * divc, msg.length)
        for (i in 0 until divc) {
            Log.e(tg, "part ${i + 1} of ${divc + 1} :" + msg.substring(i * MAX_LOGGER_LENGTH, (i + 1) * MAX_LOGGER_LENGTH))
        }
        Log.e(tg, tail)
    }


    /**
     * 使用默认Tag[DEFAULT_TAG]来输出Warn日志
     */
    fun w(msg: String) {
        w(null, msg)
    }

    /**
     * 使用指定的Tag[tag],为null时使用默认的Tag[DEFAULT_TAG]来输出Warn日志
     */
    fun w(tag: String?, msg: String) {
        val tg = tag ?: DEFAULT_TAG
        val divc = msg.length / MAX_LOGGER_LENGTH
        val tail = if (divc == 0) msg else "part ${divc + 1} of ${divc + 1} :" + msg.substring(MAX_LOGGER_LENGTH * divc, msg.length)
        for (i in 0 until divc) {
            Log.w(tg, "part ${i + 1} of ${divc + 1} :" + msg.substring(i * MAX_LOGGER_LENGTH, (i + 1) * MAX_LOGGER_LENGTH))
        }
        Log.w(tg, tail)
    }




}