package com.macaulish.top.velvet.util

import android.content.Context
import android.os.Environment
import android.os.Environment.MEDIA_MOUNTED_READ_ONLY
import android.os.Environment.MEDIA_MOUNTED
import java.io.File


/**
 * created by hu
 * at 2018/7/8
 * in project salmon
 * description 安卓存储管理工具
 */
object StorageKits {

    /**
     * Checks if external storage is available for read and write
     */
    fun isExternalStorageWritable(): Boolean {
        val state = Environment.getExternalStorageState()
        return Environment.MEDIA_MOUNTED == state
    }

    /**
     * Checks if external storage is available to at least read
     */
    fun isExternalStorageReadable(): Boolean {
        val state = Environment.getExternalStorageState()
        return Environment.MEDIA_MOUNTED == state || Environment.MEDIA_MOUNTED_READ_ONLY == state
    }

    /**
     * 在应用的内部存储中创建文件[file]，并设定文件访问权限[mode]
     * 建议直接使用 openFileInput() openFileOutput()对内存文件进行读写操作
     */
    fun getInternalFile(context: Context, file: String, mode: Int): File {
        return context.getDir(file, mode)
    }

    /**
     * 获得内部缓存的根目录
     */
    fun getInternalCacheDir(context: Context): File {
        return context.cacheDir
    }

    /**
     * 获得外部私有存储的根目录
     */
    fun getExternalPersonalRoot(context: Context): File {
        return context.getExternalFilesDir(null)
    }

    /**
     * 获得外部私有缓存的根目录
     */
    fun getExternalPersonalCacheRoot(context: Context): File {
        return context.externalCacheDir
    }

    /**
     * 获得外部私有存储的子文件夹或根目录
     * 通过[type] 指定需要获得的子目录，为 null 时指定为根目录
     * [type]有以下取值：
     * [android.os.Environment.DIRECTORY_NOTIFICATIONS]
     * [android.os.Environment.DIRECTORY_MOVIES]
     * [android.os.Environment.DIRECTORY_ALARMS]
     * [android.os.Environment.DIRECTORY_MUSIC]
     * [android.os.Environment.DIRECTORY_PICTURES]
     * [android.os.Environment.DIRECTORY_PODCASTS]
     * [android.os.Environment.DIRECTORY_RINGTONES]
     */
    fun getExternalPersonalDir(context: Context, type: String?): File {
        return context.getExternalFilesDir(type)
    }

    /**
     * 获得外部外部共享存储的子文件夹
     * 通过[type]指定需要获得的子文件夹，不可为 null
     * [type]为以下取值之一：
     * [android.os.Environment.DIRECTORY_MUSIC]
     * [android.os.Environment.DIRECTORY_PODCASTS]
     * [android.os.Environment.DIRECTORY_RINGTONES]
     * [android.os.Environment.DIRECTORY_ALARMS]
     * [android.os.Environment.DIRECTORY_NOTIFICATIONS]
     * [android.os.Environment.DIRECTORY_PICTURES]
     * [android.os.Environment.DIRECTORY_MOVIES]
     * [android.os.Environment.DIRECTORY_DOWNLOADS]
     * [android.os.Environment.DIRECTORY_DCIM]
     * [android.os.Environment.DIRECTORY_DOCUMENTS]
     */
    fun getExternalPublicDir(type: String): File {
        return Environment.getExternalStoragePublicDirectory(type)
    }

    /**
     * 获得外部共享存储的根目录
     */
    fun getExternalPublicRoot(): File {
        return Environment.getExternalStorageDirectory()
    }

}