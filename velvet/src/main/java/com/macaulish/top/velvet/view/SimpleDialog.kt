package com.macaulish.top.velvet.view

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.EditText


/**
 * created by hu
 * at 2018/7/10
 * in project salmon
 * description 简易对话框，封装了[]
 */
class SimpleDialog(val context: Context) {
    //是否可以取消对话框
    var cancelable = true
    //取消对话框监听器
    var cancelListener: DialogInterface.OnCancelListener? = null

    /**
     * 创建通知对话框，标题为[title]，内容为[message]，确认监听器为[listener]，可为空
     */
    fun alert(title: String, message: String, listener: DialogInterface.OnClickListener?) {
        AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("确认", listener)
                .setCancelable(cancelable)
                .setOnCancelListener(cancelListener)
                .show()
    }

    /**
     * 创建通知对话框，标题为[title]，内容为[message]，确认监听器为空，不触发事件
     */
    fun alert(title: String, message: String) {
        alert(title, message, null)
    }

    /**
     * 创建通知对话框，标题为 “通知”，内容为[message]，确认监听器为空，不触发事件
     */
    fun alert(message: String) {
        alert(ALERT_DEFAULT_TITLE, message)
    }

    /**
     * 创建确认对话框，标题为[title]，内容为[message]，确定按钮显示内容[yesLabel]，否定按钮显示内容[noLabel]
     * 并指定确定按键的监听器[positiveListener]和否定按键的监听器[negativeListener]，监听器都可为 null，即不触发事件
     */
    fun confirm(title: String, message: String, yesLabel: String, noLabel: String, positiveListener: DialogInterface.OnClickListener?, negativeListener: DialogInterface.OnClickListener?) {
        AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(yesLabel, positiveListener)
                .setNegativeButton(noLabel, negativeListener)
                .setCancelable(cancelable)
                .setOnCancelListener(cancelListener)
                .show()
    }

    /**
     * 创建确认对话框，标题为[title]，内容为[message]，确定按钮显示内容 “是”，否定按钮显示内容 “否”
     * 并指定确定按键的监听器[positiveListener]和否定按键的监听器[negativeListener]，监听器都可为 null，即不触发事件
     */
    fun confirm(title: String, message: String, positiveListener: DialogInterface.OnClickListener?, negativeListener: DialogInterface.OnClickListener?) {
        confirm(title, message, "是", "否", positiveListener, negativeListener)
    }

    /**
     * 创建确认对话框，标题为 “请您确认”，内容为[message]，确定按钮显示内容 “是”，否定按钮显示内容 “否”
     * 并指定确定按键的监听器[positiveListener]和否定按键的监听器[negativeListener]，监听器都可为 null，即不触发事件
     */
    fun confirm(message: String, positiveListener: DialogInterface.OnClickListener?, negativeListener: DialogInterface.OnClickListener?) {
        confirm(CONFIRM_DEFAULT_TITLE, message, positiveListener, negativeListener)
    }

    /**
     * 创建确认对话框，标题为[title]，内容为[message]，确定按钮显示内容 “是”，否定按钮显示内容 “否”
     * 不指定任何按键监听器
     */
    fun confirm(title: String, message: String) {
        confirm(title, message, "是", "否", null, null)
    }

    /**
     * 创建确认对话框，标题为 “请您确认”，内容为[message]，确定按钮显示内容 “是”，否定按钮显示内容 “否”
     * 不指定任何按键监听器
     */
    fun confirm(message: String) {
        confirm(CONFIRM_DEFAULT_TITLE, message, "是", "否", null, null)
    }

    /**
     * 创建输入对话框，标题为[title]，确认按钮显示内容[confirmLabel]，
     * 确认输入监听器[confirmListener]，可为 null，即不监听
     */
    fun prompt(title: String, message: String, confirmLabel: String, confirmListener: OnConfirmListener?) {
        val edt = EditText(context)
        edt.minLines = 1
        AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setView(edt)
                .setPositiveButton(confirmLabel) { dialog, which -> confirmListener?.onClick(dialog, which, edt.text.toString()) }
                .setCancelable(cancelable)
                .setOnCancelListener(cancelListener)
                .show()
    }

    /**
     * 创建输入对话框，标题为 “请您输入”，确认按钮显示内容 “确定”，
     * 确认输入监听器[confirmListener]，可为 null，即不监听
     */
    fun prompt(message: String, confirmListener: OnConfirmListener?) {
        prompt(PROMPT_DEFAULT_TITLE, message, "确定", confirmListener)
    }


    /**
     * 创建输入对话框，标题为 “请您输入”，确认按钮显示内容 “确定”，
     * 确认输入监听器[confirmListener]，取消输入监听器 null,不监听取消行为
     */
    fun prompt(confirmListener: OnConfirmListener?) {
        prompt(PROMPT_DEFAULT_TITLE, "", "确定", confirmListener)
    }

    interface OnConfirmListener {
        fun onClick(dialog: DialogInterface, which: Int, result: String)
    }


    companion object {
        private const val ALERT_DEFAULT_TITLE = "通知对话框"
        private const val CONFIRM_DEFAULT_TITLE = "确认对话框"
        private const val PROMPT_DEFAULT_TITLE = "输入对话框"

    }
}