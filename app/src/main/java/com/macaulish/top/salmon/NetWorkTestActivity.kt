package com.macaulish.top.salmon

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.macaulish.top.coconut.util.DateUtils
import com.macaulish.top.velvet.util.NetUtils
import kotlinx.android.synthetic.main.activity_network_state_test.*
import java.util.*

/**
 * created by hu
 * at 2018/7/7
 * in project salmon
 * description
 */
class NetWorkTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network_state_test)
        setEventListener()
    }

    @SuppressLint("c")
    private fun setEventListener() {
        network_state_btn_test.setOnClickListener {
            val isConnected = NetUtils.isConnected(this)
            val isFast = NetUtils.isConnectedFast(this)
            val isMobileNet = NetUtils.isConnectedMobile(this)
            val isWifiNet = NetUtils.isConnectedWifi(this)
            val connectType = when (NetUtils.getConnectType(this)) {
                NetUtils.NETWORK_STATE_2G -> "2G"
                NetUtils.NETWORK_STATE_3G -> "3G"
                NetUtils.NETWORK_STATE_4G -> "4G"
                NetUtils.NETWORK_STATE_WIFI -> "WIFI"
                NetUtils.NETWORK_STATE_UNKNOWN -> "UNKNOWN"
                else -> "UNKNOWN"
            }
            val log = "${DateUtils.getNowLocal()} 已连接：$isConnected  快速连接：$isFast  手机网络：$isMobileNet  WIFI：$isWifiNet 网络类型：$connectType${System.lineSeparator()}"
            network_state_tv_log.append(log)
        }
        network_state_btn_clear.setOnClickListener {
            network_state_tv_log.text = ""
        }
    }

}