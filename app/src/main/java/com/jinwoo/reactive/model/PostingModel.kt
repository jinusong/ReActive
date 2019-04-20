package com.jinwoo.reactive.model

import com.google.gson.annotations.SerializedName

data class PostingModel(
    @SerializedName("content")
    val content: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("video_url")
    val video_url: String,
    @SerializedName("hash_tag")
    val hashTag: String
)