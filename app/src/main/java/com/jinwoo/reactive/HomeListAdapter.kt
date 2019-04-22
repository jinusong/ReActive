package com.jinwoo.reactive

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.jinwoo.reactive.model.PostListModel
import org.jetbrains.anko.find

class HomeListAdapter(val models: ArrayList<PostListModel>): RecyclerView.Adapter<HomeListAdapter.HomeListViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HomeListViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_home, p0, false)
        return HomeListViewHolder(view)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(p0: HomeListViewHolder, p1: Int) = p0.bind(models[p1])

    inner class HomeListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val history = itemView.find<TextView>(R.id.item_home_time_ago)
        val date = itemView.find<TextView>(R.id.item_home_date)
        val image = itemView.find<ImageView>(R.id.item_home_image)
        val hashTag = itemView.find<TextView>(R.id.item_home_hash_tag)
        val scoreViewLayout = itemView.find<TextView>(R.id.item_home_myscore_view_lay)
        val commentList = itemView.find<TextView>(R.id.item_home_comment_list)
        fun bind(model: PostListModel) {

        }
    }
}