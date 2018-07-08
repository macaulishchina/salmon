package com.macaulish.top.salmon

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.macaulish.top.coconut.util.DateKits
import com.macaulish.top.velvet.util.NetKits
import kotlinx.android.synthetic.main.activity_network_state_test.*

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
            val isConnected = NetKits.isConnected(this)
            val isFast = NetKits.isConnectedFast(this)
            val isMobileNet = NetKits.isConnectedMobile(this)
            val isWifiNet = NetKits.isConnectedWifi(this)
            val connectType = when (NetKits.getConnectType(this)) {
                NetKits.NETWORK_STATE_2G -> "2G"
                NetKits.NETWORK_STATE_3G -> "3G"
                NetKits.NETWORK_STATE_4G -> "4G"
                NetKits.NETWORK_STATE_WIFI -> "WIFI"
                NetKits.NETWORK_STATE_UNKNOWN -> "UNKNOWN"
                else -> "UNKNOWN"
            }
            val log = "${DateKits.getNowLocal()} 已连接：$isConnected  快速连接：$isFast  手机网络：$isMobileNet  WIFI：$isWifiNet 网络类型：$connectType${System.lineSeparator()}"
            network_state_tv_log.append(log)
        }
        network_state_btn_clear.setOnClickListener {
            network_state_tv_log.text = ""
        }
    }

}