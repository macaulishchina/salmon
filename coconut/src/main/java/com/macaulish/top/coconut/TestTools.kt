package com.macaulish.top.coconut

import com.macaulish.top.coconut.util.FileUtils
import org.junit.Test
import java.io.File
import java.io.FileWriter
import java.io.PrintWriter

/**
 * created by hu
 * at 2018/7/6
 * in project salmon
 * description
 */
class TestTools {

    @Test
    fun testFileUtils() {
        val file = File("../teext.xt")
        if (file == null) {
            println("文件获取失败")
        } else {
            val fileWriter = FileWriter(file)
            fileWriter.close()
            print("文件获取成功：${file.canonicalPath}")

        }

    }
}