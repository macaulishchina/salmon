package com.macaulish.top.velvet.util

import android.content.Context
import android.net.ConnectivityManager
import android.telephony.TelephonyManager
import android.net.NetworkInfo


/**
 * created by hu
 * at 2018/7/7
 * in project salmon
 * description 安卓网络相关的方法
 */
object NetKits {

    /**
     * 查询是否存在连接
     */
    fun isConnected(context: Context): Boolean {
        val info = (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
        return info != null && info.isConnected
    }

    /**
     * 查询是否通过WIFI连接网络
     */
    fun isConnectedWifi(context: Context): Boolean {
        val info = getNetworkInfo(context)
        return info != null && info.isConnected && info.type == ConnectivityManager.TYPE_WIFI
    }

    /**
     * 查询是否通过移动信号基站连接网络
     */
    fun isConnectedMobile(context: Context): Boolean {
        val info = getNetworkInfo(context)
        return info != null && info.isConnected && info.type == ConnectivityManager.TYPE_MOBILE
    }

    /**
     * 查询连接的速度
     */
    fun isConnectedFast(context: Context): Boolean {
        val info = getNetworkInfo(context)
        return info != null && info.isConnected && isConnectionFast(info.type, info.subtype)
    }

    /**
     * 查询连接的类型区分为 2G、3G、4G、WIFI和其它为止连接方式
     */
    fun getConnectType(context: Context): Int {
        if (isConnectedWifi(context)) return NETWORK_STATE_WIFI
        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        val networkType = telephonyManager.networkType
        return when (networkType) {
            TelephonyManager.NETWORK_TYPE_GPRS,
            TelephonyManager.NETWORK_TYPE_EDGE,
            TelephonyManager.NETWORK_TYPE_CDMA,
            TelephonyManager.NETWORK_TYPE_1xRTT,
            TelephonyManager.NETWORK_TYPE_IDEN -> NETWORK_STATE_2G
            TelephonyManager.NETWORK_TYPE_UMTS,
            TelephonyManager.NETWORK_TYPE_EVDO_0,
            TelephonyManager.NETWORK_TYPE_EVDO_A,
            TelephonyManager.NETWORK_TYPE_HSDPA,
            TelephonyManager.NETWORK_TYPE_HSUPA,
            TelephonyManager.NETWORK_TYPE_HSPA,
            TelephonyManager.NETWORK_TYPE_EVDO_B,
            TelephonyManager.NETWORK_TYPE_EHRPD,
            TelephonyManager.NETWORK_TYPE_HSPAP -> NETWORK_STATE_3G
            TelephonyManager.NETWORK_TYPE_LTE -> NETWORK_STATE_4G
            else -> NETWORK_STATE_UNKNOWN
        }
    }

    /**
     * 通过连接的具体分类[type]和移动网络类型子分类[subType]查询是否是快速的连接
     */
    private fun isConnectionFast(type: Int, subType: Int): Boolean {
        return when (type) {
            ConnectivityManager.TYPE_WIFI -> true
            ConnectivityManager.TYPE_MOBILE -> when (subType) {
                TelephonyManager.NETWORK_TYPE_1xRTT -> false // ~ 50-100 kbps
                TelephonyManager.NETWORK_TYPE_CDMA -> false // ~ 14-64 kbps
                TelephonyManager.NETWORK_TYPE_EDGE -> false // ~ 50-100 kbps
                TelephonyManager.NETWORK_TYPE_EVDO_0 -> true // ~ 400-1000 kbps
                TelephonyManager.NETWORK_TYPE_EVDO_A -> true // ~ 600-1400 kbps
                TelephonyManager.NETWORK_TYPE_GPRS -> false // ~ 100 kbps
                TelephonyManager.NETWORK_TYPE_HSDPA -> true // ~ 2-14 Mbps
                TelephonyManager.NETWORK_TYPE_HSPA -> true // ~ 700-1700 kbps
                TelephonyManager.NETWORK_TYPE_HSUPA -> true // ~ 1-23 Mbps
                TelephonyManager.NETWORK_TYPE_UMTS -> true // ~ 400-7000 kbps
            /*
             * Above API level 7, make sure to set android:targetSdkVersion
             * to appropriate level to use these
             */
                TelephonyManager.NETWORK_TYPE_EHRPD // API level 11
                -> true // ~ 1-2 Mbps
                TelephonyManager.NETWORK_TYPE_EVDO_B // API level 9
                -> true // ~ 5 Mbps
                TelephonyManager.NETWORK_TYPE_HSPAP // API level 13
                -> true // ~ 10-20 Mbps
                TelephonyManager.NETWORK_TYPE_IDEN // API level 8
                -> false // ~25 kbps
                TelephonyManager.NETWORK_TYPE_LTE // API level 11
                -> true // ~ 10+ Mbps
            // Unknown
                TelephonyManager.NETWORK_TYPE_UNKNOWN -> false
                else -> false
            }
            else -> false
        }
    }


    /**
     * 查询是否有网络连接，如果有判断网络连接的类型
     * 网络连接是否存在以及网络的类型可以通过比对返回的整型量和常量表[NETWORK_STATE_*]来判断
     */
    @Deprecated(message = "建议使用[getConnectType(context)]方法")
    fun checkNetworkConnection(context: Context): Int {

        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeInfo = connMgr.activeNetworkInfo ?: return NETWORK_STATE_OFF

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
            else -> NETWORK_STATE_UNKNOWN
        }
    }

    /**
     * 获得网络连接信息对象
     */
    private fun getNetworkInfo(context: Context): NetworkInfo? {
        return (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
    }

    const val NETWORK_STATE_UNKNOWN = -1     //未知的网络连接方式
    @Deprecated(message = "[checkNetworkConnection(context)]方法使用")
    const val NETWORK_STATE_OFF = 0         //没有网络连接
    @Deprecated(message = "[checkNetworkConnection(context)]方法使用")
    const val NETWORK_STATE_MOBILE = 1      //移动数据连接
    @Deprecated(message = "[checkNetworkConnection(context)]方法使用")
    const val NETWORK_STATE_BLUETOOTH = 3   //蓝牙连接
    @Deprecated(message = "[checkNetworkConnection(context)]方法使用")
    const val NETWORK_STATE_VPN = 4         //虚拟局域网连接
    @Deprecated(message = "[checkNetworkConnection(context)]方法使用")
    const val NETWORK_STATE_ETHERNET = 5    //以太网连接
    @Deprecated(message = "[checkNetworkConnection(context)]方法使用")
    const val NETWORK_STATE_DUMMY = 6       //虚拟连接
    @Deprecated(message = "[checkNetworkConnection(context)]方法使用")
    const val NETWORK_STATE_WIMAX = 7       //全球互通微波存取数据连接
    @Deprecated(message = "[checkNetworkConnection(context)]方法使用")
    const val NETWORK_STATE_MOBILE_DUN = 8  //桥接网络连接

    const val NETWORK_STATE_WIFI = 2        //WIFI连接
    const val NETWORK_STATE_2G = 12          //2G移动网络
    const val NETWORK_STATE_3G = 13          //3G移动网络
    const val NETWORK_STATE_4G = 14          //4G移动网络
}