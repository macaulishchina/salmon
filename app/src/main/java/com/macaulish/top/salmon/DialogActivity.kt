package com.macaulish.top.salmon

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.macaulish.top.velvet.util.Logger
import com.macaulish.top.velvet.view.SimpleDialog

import kotlinx.android.synthetic.main.activity_dialog_acitiviy.*

class DialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_acitiviy)
    }

    override fun onStart() {
        super.onStart()
        setEventListener()
    }

    private fun setEventListener() {
        val dialog = SimpleDialog(this)
        dialog.cancelable = true
        dialog.cancelListener = DialogInterface.OnCancelListener {
            Logger.i("你点击了取消$dialog")
        }
        dialog_btn_alert.setOnClickListener {
            dialog.alert("标题", "内容", DialogInterface.OnClickListener { _, _ ->
                Logger.i("你点击了确认")
            })
        }
        dialog_btn_confirm.setOnClickListener {
            val onYes = DialogInterface.OnClickListener { _, _ ->
                Logger.i("你点击了是")
            }
            val onNo = DialogInterface.OnClickListener { _, _ ->
                Logger.i("你点击了否")
            }
            dialog.confirm("请确认", "您的生日是1996年6月10日？", "是", "是个屁", onYes, onNo)
        }

        dialog_btn_prompt.setOnClickListener {
            val onConfirm = object : SimpleDialog.OnConfirmListener {
                override fun onClick(dialog: DialogInterface, which: Int, result: String) {
                    Logger.i("你输入的内容是:$result")
                }

            }
            dialog.prompt("标题", "请输入", "确定", onConfirm)
        }

    }

}
