package com.macaulish.top.coconut.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * created by hu
 * at 2018/7/7
 * in project salmon
 * description
 */
object DateKits {


    /**
     * 按指定的时间格式[format]显示当前日期和时间
     */
    fun getNow(format: String): String {
        val sdf = SimpleDateFormat(format)
        return sdf.format(Date())
    }

    /**
     * 使用默认的时间格式[DEFAULT_TIME_FORMAT]显示当前日期和时间
     */
    fun getNow(): String {
        return getNow(DEFAULT_TIME_FORMAT)
    }

    /**
     * 使用本地的时间格式显示日期和时间
     */
    fun getNowLocal(): String {
        return SimpleDateFormat.getDateTimeInstance().format(Date())
    }

    /**
     * 以[format]格式返回[date]的日期时间
     */
    fun format(date: Date, format: String): String {
        val sdf = SimpleDateFormat(format)
        return sdf.format(date)
    }

    /**
     * 已默认格式[DEFAULT_TIME_FORMAT]转换日期
     */
    fun format(date: Date): String {
        return format(date, DEFAULT_TIME_FORMAT)
    }

    private const val DEFAULT_TIME_FORMAT = "yyyy/MM/dd hh:mm:ss"

}