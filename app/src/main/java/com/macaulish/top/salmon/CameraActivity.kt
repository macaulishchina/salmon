package com.macaulish.top.salmon

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_camera.*
import android.support.v4.app.ActivityCompat
import android.support.v4.content.FileProvider
import com.macaulish.top.coconut.util.DateKits
import com.macaulish.top.velvet.util.StorageKits
import com.macaulish.top.velvet.util.Toaster
import com.macaulish.top.velvet.util.UriKits
import java.io.File


/**
 * created by hu
 * at 2018/7/7
 * in project salmon
 * description
 */
class CameraActivity : AppCompatActivity() {

    private lateinit var imageUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        requestPermissions()
        setEventListener()
    }

    private fun setEventListener() {
        camera_btn_take_photo.setOnClickListener {

            Toaster.shortToast(this, "打开相机")

            allocateStorage()

            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
            startActivityForResult(intent, RESULT_ACTIVITY_MEDIA_CAMERA)
        }
    }

    /**
     * 为[imageUri]分配存储资源的具体位置
     */
    private fun allocateStorage() {
        //存储在外部公共存储的Picture文件夹中
        val dirPath = "" + StorageKits.getExternalPublicDir(Environment.DIRECTORY_PICTURES) + File.separator + SALMON_DIRECTORY_NAME
        val fileName = "" + DateKits.getNow("yyyyMMddhhmmss") + ".jpg"
        val path = dirPath + File.separator + fileName
        //获得此路径[filePath]的URI
        imageUri = UriKits(this, "${application.packageName}.Provider").getUriByFilePath(path)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode) {
            Activity.RESULT_OK -> when (requestCode) {
                RESULT_ACTIVITY_MEDIA_CAMERA -> {
                    camera_iv_display.setImageURI(imageUri)
                }
            }
        }

    }

    /**
     * 请求相关运行时权限
     */
    private fun requestPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            camera_btn_take_photo.isEnabled = false
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE), PERMISSION_REQUEST_CODE_DEFAULT)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_CODE_DEFAULT -> {
                val ack = grantResults.size >= 2
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED
                camera_btn_take_photo.isEnabled = ack
            }
        }
    }

    companion object {
        const val PERMISSION_REQUEST_CODE_DEFAULT = 0

        const val RESULT_ACTIVITY_MEDIA_CAMERA = 100

        const val SALMON_DIRECTORY_NAME = "salmon"
    }
}