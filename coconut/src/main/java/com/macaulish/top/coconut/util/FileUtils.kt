package com.macaulish.top.coconut.util

import java.io.File
import java.math.RoundingMode
import java.nio.file.Path
import java.text.DecimalFormat

/**
 * created by hu
 * at 2018/7/4
 * in project salmon
 * description 文件处理工具
 */
object FileUtils {

    /**
     * 获得文件[file]的大小，单位为字节
     * 如果文件不存在则返回 -1
     */
    fun getSizeCountByte(file: File): Long {
        return if (file.exists() && file.isFile) file.length() else -1
    }

    /**
     * 获得文件[file]的大小，返回方便阅读的字符串形式，自动选择合适的单位
     * 如果文件不存在则返回 "null"
     */
    fun getReadableSize(file: File): String {
        return toReadableSize(getSizeCountByte(file))
    }

    /**
     * 将一个单位为字节的长度[size]转换为方便阅读的形式
     * 单位可为Byte、KB、MB、GB、TB、PB或EB，自动选择合适的单位，例如：1.267GB
     * [size]小于0时返回 "null"
     */
    fun toReadableSize(size: Long): String {
        if (size < 0) return "null"
        var decimal = 0.0
        var integer = size
        var count = 0
        while (integer > 1024) {
            decimal = decimal / 1024 + integer % 1024 / 1024.0
            integer /= 1024
            count++
        }
        val format = DecimalFormat()
        format.maximumFractionDigits = 3
        format.roundingMode = RoundingMode.HALF_EVEN
        return format.format(decimal + integer) + when (count) {
            0 -> "Byte"
            1 -> "KB"
            2 -> "MB"
            3 -> "GB"
            4 -> "TB"
            5 -> "PB"
            6 -> "EB"
            else -> "??"
        }
    }

    /**
     * 获得[filePath]指定的文件，如果该路径的文件不存在则尝试新建一个该路径下的文件
     * 支持相对路径 "./"、"../"的写法，不以根目录或盘符开头则默认以 "./'开头，例如 "music/demo.mp3" = "./music/demo.mp3"
     * 在windows文件系统中使用 "/"开头将指向运行环境的磁盘根目录下
     * 在创建文件时可能抛出异常 [FileSystemException]
     */
    fun getOrCreate(filePath: String): File? {
        val file = File(File(filePath).canonicalPath)
        val dir = file.parent ?: return null
        File(dir).mkdirs()
        file.createNewFile()
        //TODO test
        return file
    }


    /**
     *
     */
    fun getFile(filePath: String): File? {
        //TODO
        return File(filePath)
    }

    fun copy(file: File, rename: String): File? {
        //TODO
        return null
    }


}