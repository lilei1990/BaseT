package com.lilei.pwdpie

import androidx.paging.Pager
import androidx.paging.PagingConfig

/**
 * 作者 : LiLei
 * 时间 : 2020/11/05.
 * 邮箱 :416587959@qq.com
 * 描述 :
 */
class ArticleRepository {

    fun getArticleData() = Pager(PagingConfig(pageSize = 20)){
        ArticleDataSource()
    }.flow

}