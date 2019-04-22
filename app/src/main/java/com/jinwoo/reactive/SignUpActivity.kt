package com.jinwoo.reactive

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jinwoo.reactive.Connector.api
import kotlinx.android.synthetic.main.activity_signup.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        signup_signup_btn.setOnClickListener {
            if(signup_id_edit.text.isNullOrBlank())
                toast("모든 정보를 입력해주세요")
            if(signup_password_edit.text.isNullOrBlank())
                toast("모든 정보를 입력해주세요")
            if(signup_name_edit.text.isNullOrBlank())
                toast("모든 정보를 입력해주세요")
            if(signup_age_edit.text.isNullOrBlank())
                toast("모든 정보를 입력해주세요")
            if(signup_nickname_edit.text.isNullOrBlank())
                toast("모든 정보를 입력해주세요")
            else {
                api.postSignUp(hashMapOf("id" to signup_id_edit.text, "pw" to signup_password_edit.text
                    , "nickname" to signup_nickname_edit.text, "age" to signup_age_edit.text.isNullOrBlank()))
                    .enqueue(object: Callback<Unit> {
                        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                            when (response.code()) {
                                200 -> finish()
                            }
                        }

                        override fun onFailure(call: Call<Unit>, t: Throwable) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }
                    })
            }
        }
    }
}