package com.macaulish.top.salmon

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import com.macaulish.top.velvet.util.Logger
import com.macaulish.top.velvet.util.StorageKits
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_btn_net_work_test.setOnClickListener {
            val intent = Intent(this, NetWorkTestActivity::class.java)
            startActivity(intent)
        }
        main_btn_camera_open.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
            testStorageKits()
        }
    }


    private fun testStorageKits() {
        val internalCache = StorageKits.getInternalCacheDir(this)
        val internalFile = StorageKits.getInternalFile(this, "test.txt", Context.MODE_PRIVATE)
        val externalRoot = StorageKits.getExternalPublicRoot()
        val externalPersonalRoot1 = StorageKits.getExternalPersonalRoot(this)
        val externalPersonalRoot2 = StorageKits.getExternalPersonalDir(this, null)
        val externalPersonalPictures = StorageKits.getExternalPersonalDir(this, Environment.DIRECTORY_PICTURES)
        val externalPersonalCacheRoot = StorageKits.getExternalPersonalCacheRoot(this)
        val externalPublicDirDownload = StorageKits.getExternalPublicDir(Environment.DIRECTORY_DOWNLOADS)
        Logger.i(internalCache.absolutePath)
        Logger.i(internalFile.absolutePath)
        Logger.i(externalRoot.absolutePath)
        Logger.i(externalPersonalRoot1.absolutePath)
        Logger.i(externalPersonalRoot2.absolutePath)
        Logger.i(externalPersonalPictures.absolutePath)
        Logger.i(externalPersonalCacheRoot.absolutePath)
        Logger.i(externalPublicDirDownload.absolutePath)
        /* 测试结果
        /data/user/0/com.macaulish.top.salmon/cache
        /data/user/0/com.macaulish.top.salmon/app_test.txt
        /storage/emulated/0
        /storage/emulated/0/Android/data/com.macaulish.top.salmon/files
        /storage/emulated/0/Android/data/com.macaulish.top.salmon/files
        /storage/emulated/0/Android/data/com.macaulish.top.salmon/files/Pictures
        /storage/emulated/0/Android/data/com.macaulish.top.salmon/cache
        /storage/emulated/0/Download
        */
    }
}
