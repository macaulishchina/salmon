package com.macaulish.top.velvet.util

import android.content.Context
import android.net.Uri
import android.os.Build
import android.support.v4.content.FileProvider
import com.macaulish.top.coconut.util.FileKits

/**
 * created by hu
 * at 2018/7/8
 * in project salmon
 * description
 */
class UriKits(val context: Context, val authority: String) {

    /**
     * 获得文件资源的URI
     */
    fun getUriByFilePath(filePath: String): Uri {
        val file = FileKits.getOrCreate(filePath)
        //works when API <= 23
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            return Uri.fromFile(file)
        }
        return FileProvider.getUriForFile(context, authority, file)
    }
}