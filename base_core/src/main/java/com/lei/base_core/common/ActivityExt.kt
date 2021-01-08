package com.lei.base_core.common

import android.app.Activity
import com.blankj.utilcode.util.SnackbarUtils

/**
 * 作者 : lei
 * 时间 : 2021/01/07.
 * 邮箱 :416587959@qq.com
 * 描述 :activity扩展方法
 */
/**
 * Snackbar显示信息
 */
fun Activity.showBar(message: String) {
    SnackbarUtils.with(findViewById(android.R.id.content))
        .setMessage(message)
        .show(false)
}

fun Activity.showToast(message: String) {
    SnackbarUtils.with(findViewById(android.R.id.content))
        .setMessage(message)
        .show(false)
}

/**
 * Snackbar显示警告信息
 */
fun Activity.showWarningBar(message: String) {
    SnackbarUtils.with(findViewById(android.R.id.content))
        .setMessage(message)
        .showWarning(true)
}

fun Activity.showWarningToast(message: String) {
    SnackbarUtils.with(findViewById(android.R.id.content))
        .setMessage(message)
        .showWarning(false)
}

/**
 * Snackbar显示错误信息
 */
fun Activity.showErrorBar(message: String) {
    SnackbarUtils.with(findViewById(android.R.id.content))
        .setMessage(message)
        .showError(true)
}

fun Activity.showErrorToast(message: String) {
    SnackbarUtils.with(findViewById(android.R.id.content))
        .setMessage(message)
        .showError(false)
}
