package com.lilei.pwdpie.fragment.home

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.lei.base_core.base.BaseVmFragment
import com.lilei.pwdpie.ArticleAdapter
import com.lilei.pwdpie.PagingViewModel
import com.lilei.pwdpie.PostsLoadStateAdapter
import com.lilei.pwdpie.R
import com.lilei.pwdpie.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.flow.collectLatest


class HomeFragment : BaseVmFragment<FragmentHomeBinding>() {
    private val viewModel by lazy { ViewModelProvider(this).get(PagingViewModel::class.java) }

    private val adapter: ArticleAdapter by lazy { ArticleAdapter() }
    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun init(savedInstanceState: Bundle?) {
        mBinding.content = "我是主fragment"
        //设置 Header 为 贝塞尔雷达 样式
//        refreshView.setRefreshHeader( BezierRadarHeader(activity).setEnableHorizontalDrag(true));
        //设置 Footer 为 球脉冲 样式
//        refreshView.setRefreshFooter( BallPulseFooter(activity).setSpinnerStyle(SpinnerStyle.Scale));
        recyclerView.layoutManager = GridLayoutManager(activity,3)
        // 添加间距
        recyclerView.adapter = adapter.withLoadStateFooter(PostsLoadStateAdapter(adapter))
        //获取数据并渲染UI
        viewModel.getArticleData().observe(this, Observer {
            lifecycleScope.launchWhenCreated {
                adapter.submitData(it)
            }
        })
        //监听刷新状态当刷新完成之后关闭刷新
        lifecycleScope.launchWhenCreated {
            adapter.loadStateFlow.collectLatest {
                if(it.refresh !is LoadState.Loading){
                    refreshView.finishRefresh()
                }
            }
        }
        refreshView.setOnRefreshListener {
            adapter.refresh()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }
}