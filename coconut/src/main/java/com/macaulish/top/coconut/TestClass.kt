package com.macaulish.top.coconut

import com.macaulish.top.coconut.util.DateKits
import com.macaulish.top.coconut.util.FileKits
import jdk.nashorn.internal.runtime.options.LoggingOption
import org.junit.Test
import java.io.File
import java.util.*

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
        println("\\0")
    }

    @Test
    fun testDate() {
        val date = Date()
        println(DateKits.format(date))
    }

    val pair = "result" to "?"

    fun change(results: Map<String, String>) {
    }

    @Test
    fun testReference() {

    }

}