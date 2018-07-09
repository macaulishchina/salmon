package com.macaulish.top.coconut

import com.macaulish.top.coconut.util.FileKits
import jdk.nashorn.internal.runtime.options.LoggingOption
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
        println(FileKits.getReadableSize(file))
    }

    @Test
    fun testFileKits() {
        val file = FileKits.getOrCreate("/as/ab/ab/../11")
        println(file.canonicalPath)
    }

    @Test
    fun testSubstring() {
        val str = "0123456789"
        println("\\0")
    }



}