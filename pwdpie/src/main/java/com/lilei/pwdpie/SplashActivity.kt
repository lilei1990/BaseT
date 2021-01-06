package com.lilei.pwdpie

import android.Manifest
import android.content.Intent
import android.os.Bundle
import com.blankj.utilcode.util.PermissionUtils.SimpleCallback
import com.lei.base_core.base.BaseVmActivity
import com.lei.base_core.helper.PermissionHelper
import com.lei.base_core.utils.PrefUtils
import com.lei.base_core.utils.StatusUtils
import com.lilei.pwdpie.constants.Constants
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit


/**
 * 开屏页
 * 权限：https://www.cnblogs.com/blosaa/p/9584348.html
 */
class SplashActivity : BaseVmActivity() {

    private var disposable: Disposable? = null
    private val tips = "现在要向您申请存储权限，用于访问您的本地音乐，您也可以在设置中手动开启或者取消。"
    private val perms = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        changeTheme()
        super.onCreate(savedInstanceState)
    }

    override fun init(savedInstanceState: Bundle?) {
        PermissionHelper.request(this, object : SimpleCallback {
            override fun onGranted() {
                startIntent()
            }

            override fun onDenied() {
            }
        }, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }


    /**
     * 开始倒计时跳转
     */
    private fun startIntent() {

        disposable = Observable.timer(2000, TimeUnit.MILLISECONDS)
            .subscribe {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }


    override fun getLayoutId() = R.layout.activity_splash


    /**
     * 动态切换主题
     */
    private fun changeTheme() {
        val theme = PrefUtils.getBoolean(Constants.SP_THEME_KEY, false)
        if (theme) {
            setTheme(R.style.AppTheme_Night)
        } else {
            setTheme(R.style.AppTheme)
        }
    }

    /**
     * 沉浸式状态,随主题改变
     */
    override fun setSystemInvadeBlack() {
        val theme = PrefUtils.getBoolean(Constants.SP_THEME_KEY, false)
        if (theme) {
            StatusUtils.setSystemStatus(this, true, false)
        } else {
            StatusUtils.setSystemStatus(this, true, true)
        }
    }
}
