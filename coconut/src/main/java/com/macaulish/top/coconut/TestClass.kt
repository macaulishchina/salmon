package com.macaulish.top.coconut

import com.macaulish.top.coconut.util.FileUtils
import org.junit.Test
import java.io.File

/**
 * created by hu
 * at 2018/7/4
 * in project salmon
 */
class TestClass {

    @Test
    fun testFunction() {
        val file = File("E:\\2018毕业设3计.rar")
        println(FileUtils.getReadableSize(file))
    }

}