package com.lilei.pwdpie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.ThreadUtils
import com.lei.base_core.common.CustomBindAdapter

/**
 * 作者 : LiLei
 * 时间 : 2020/11/05.
 * 邮箱 :416587959@qq.com
 * 描述 :
 */
class ArticleAdapter : PagingDataAdapter<Article, ArticleViewHolder>(POST_COMPARATOR){

    companion object{
        val POST_COMPARATOR = object : DiffUtil.ItemCallback<Article>() {
            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem.id == newItem.id
        }
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.tvName.text = getItem(position)?.title
        CustomBindAdapter.imgSrc(holder.ivico,R.mipmap.pwd_folders_app)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_category_item,parent,false))
    }

}
class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val tvName: TextView = itemView.findViewById(R.id.tvname)
    val ivico: ImageView = itemView.findViewById(R.id.iv_ico)
}