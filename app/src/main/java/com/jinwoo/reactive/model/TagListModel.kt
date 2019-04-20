package com.jinwoo.reactive.model

import com.google.gson.annotations.SerializedName

data class TagListModel(
    @SerializedName("rank_hash_tag")
    val rankHashTag: ArrayList<HashTagModel>
) {
    data class HashTagModel(
        @SerializedName("hash_tag")
        val hashTag: String
    )
}