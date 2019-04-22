package com.jinwoo.reactive

import com.jinwoo.reactive.model.PostListModel
import com.jinwoo.reactive.model.PostingModel
import com.jinwoo.reactive.model.TagListModel
import com.jinwoo.reactive.model.TokenModel
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @POST("signUp")
    fun postSignUp(@Body body: Any): Call<Unit>

    @POST("signIn")
    fun postSignIn(@Body body: Any): Call<TokenModel>

    @GET
    fun getPostList(@Header("Authorization") token: String): Call<PostListModel>

    @GET("recommand")
    fun getRecommand(@Header("Authorization") token: String): Call<PostListModel>

    @GET("tagList")
    fun getTagList(): Call<TagListModel>

    @PATCH("{post_id}/score")
    fun patchScore(@Path("post_id") postId: Int, @Body body: Any ): Call<Unit>

    @POST("{post_id}/cop=mment")
    fun postComment(@Path("post_id") postId: Int, @Body body: Any ): Call<Unit>

    @POST
    fun postPosting(@Header("Authorization") token: String): Call<PostingModel>

    @GET("tag/post")
    fun getHashTagPost(): Call<PostListModel>

    @GET("search/{searchWord}")
    fun postSearch(@Path("searchWord") searchWord: String): Call<PostListModel>
}