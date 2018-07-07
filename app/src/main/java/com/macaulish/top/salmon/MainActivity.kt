package com.macaulish.top.salmon

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_btn_net_work_test.setOnClickListener {
            val intent = Intent(this, NetWorkTestActivity::class.java)
            startActivity(intent)
        }
    }
}
