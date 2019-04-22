package com.jinwoo.reactive

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class SplashActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (getToken(this).isNullOrBlank()){
                startActivity<MainActivity>()
                finish()
            } else {
                startActivity<MainActivity>()
                finish()
            }
        } else {
            toast("안드로이드 버전이 낮습니다.")
        }
    }
}