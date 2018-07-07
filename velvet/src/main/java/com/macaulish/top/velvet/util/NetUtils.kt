package com.macaulish.top.velvet.util

import android.content.Context
import android.net.ConnectivityManager

/**
 * created by hu
 * at 2018/7/7
 * in project salmon
 * description 安卓相关的网络相关的方法
 */
object NetUtils {

    /**
     * 检查是否有网络连接，如果有判断网络连接的类型
     * 网络连接是否存在以及网络的类型可以通过比对返回的整型量和常量表[NETWORK_STATE_*]来判断
     */
    private fun checkNetworkConnection(context: Context): Int {

        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeInfo = connMgr.activeNetworkInfo ?: return NETWORK_STATE_UNKONW

        return if (!activeInfo.isConnected) NETWORK_STATE_OFF
        else when (activeInfo.type) {
            ConnectivityManager.TYPE_MOBILE -> NETWORK_STATE_MOBILE
            ConnectivityManager.TYPE_WIFI -> NETWORK_STATE_WIFI
            ConnectivityManager.TYPE_BLUETOOTH -> NETWORK_STATE_BLUETOOTH
            ConnectivityManager.TYPE_VPN -> NETWORK_STATE_VPN
            ConnectivityManager.TYPE_ETHERNET -> NETWORK_STATE_ETHERNET
            ConnectivityManager.TYPE_DUMMY -> NETWORK_STATE_DUMMY
            ConnectivityManager.TYPE_WIMAX -> NETWORK_STATE_WIMAX
            ConnectivityManager.TYPE_MOBILE_DUN -> NETWORK_STATE_MOBILE_DUN
            else -> NETWORK_STATE_UNKONW
        }
    }

    const val NETWORK_STATE_UNKONW = -1     //未知的网络连接方式
    const val NETWORK_STATE_OFF = 0         //没有网络连接
    const val NETWORK_STATE_MOBILE = 1      //移动数据连接
    const val NETWORK_STATE_WIFI = 2        //WIFI连接
    const val NETWORK_STATE_BLUETOOTH = 3   //蓝牙连接
    const val NETWORK_STATE_VPN = 4         //虚拟局域网连接
    const val NETWORK_STATE_ETHERNET = 5    //以太网连接
    const val NETWORK_STATE_DUMMY = 6       //虚拟连接
    const val NETWORK_STATE_WIMAX = 7       //全球互通微波存取数据连接
    const val NETWORK_STATE_MOBILE_DUN = 8  //桥接网络连接

}