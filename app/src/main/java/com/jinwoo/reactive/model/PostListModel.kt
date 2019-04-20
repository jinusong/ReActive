package com.jinwoo.reactive.model

import com.google.gson.annotations.SerializedName

data class PostListModel(
    @SerializedName("post")
    val post: PostModel,
    @SerializedName("comment")
    val comment: ArrayList<CommentModel>
) {
    data class PostModel(
        @SerializedName("post_id")
        val postId: Int,
        @SerializedName("content")
        val content: String,
        @SerializedName("image")
        val image: String,
        @SerializedName("video_url")
        val videoUrl: String,
        @SerializedName("writer")
        val writer: String,
        @SerializedName("hash_tag")
        val hashTag: String,
        @SerializedName("age")
        val age: Int,
        @SerializedName("score")
        val score: Float
    )

    data class CommentModel(
        @SerializedName("content")
        val content: String,
        @SerializedName("writer")
        val writer: String
    )
}