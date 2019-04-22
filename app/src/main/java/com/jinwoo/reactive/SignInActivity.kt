package com.jinwoo.reactive

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jinwoo.reactive.Connector.api
import com.jinwoo.reactive.model.TokenModel
import kotlinx.android.synthetic.main.activity_signin.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        signin_signup_btn.setOnClickListener {startActivity<SignUpActivity>()}

        signin_signin_btn.setOnClickListener {
            api.postSignIn(hashMapOf("id" to signin_id_edit.text, "pw" to signin_password_edit.text))
                .enqueue(object: Callback<TokenModel>{
                    override fun onResponse(call: Call<TokenModel>, response: Response<TokenModel>) {
                        when(response.code()) {
                            200 -> {
                                saveToken(applicationContext, response.body()!!.token)
                                toast("로그인 성공")
                                startActivity<MainActivity>()
                                finish()
                            }

                        }
                    }

                    override fun onFailure(call: Call<TokenModel>, t: Throwable) {

                    }
                })
        }

    }
}