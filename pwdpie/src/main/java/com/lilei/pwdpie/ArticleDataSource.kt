package com.lilei.pwdpie

import androidx.paging.PagingSource

/**
 * 作者 : LiLei
 * 时间 : 2020/11/05.
 * 邮箱 :416587959@qq.com
 * 描述 :
 */
class ArticleDataSource : PagingSource<Int, Article>() {

    /**
     * 实现这个方法来触发异步加载(例如从数据库或网络)。 这是一个suspend挂起函数，可以很方便的使用协程异步加载
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {

        return try {
            val page = params.key ?: 0
            val arrayList = ArrayList<Article>()
            arrayList.add(Article(1, "李雷1"))
            arrayList.add(Article(2, "李雷2"))
            arrayList.add(Article(3, "李雷3"))
            arrayList.add(Article(4, "李雷4"))
            arrayList.add(Article(4, "李雷4"))
            arrayList.add(Article(4, "李雷4"))


            //获取网络数据
            val result = arrayList
            LoadResult.Page(
                //需要加载的数据
                data = arrayList,
                //如果可以往上加载更多就设置该参数，否则不设置
                prevKey = null,
                //加载下一页的key 如果传null就说明到底了
                nextKey = null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}