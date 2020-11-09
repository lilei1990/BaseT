package com.lilei.pwdpie.fragment.mine

import android.os.Bundle
import com.lei.base_core.base.BaseVmFragment
import com.lilei.pwdpie.R
import com.lilei.pwdpie.databinding.FragmentHomeBinding
import com.lilei.pwdpie.databinding.FragmentMineBinding
import com.scwang.smart.refresh.footer.BallPulseFooter
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.BezierRadarHeader
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.constant.SpinnerStyle
import kotlinx.android.synthetic.main.fragment_mine.*

class MineFragment : BaseVmFragment<FragmentHomeBinding>() {

    companion object {
        fun newInstance() = MineFragment()
    }

    override fun init(savedInstanceState: Bundle?) {
//        mBinding.content = "这是我的界面"
//        final RefreshLayout refreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
//设置 Header 为 贝塞尔雷达 样式
        refreshLayout.setRefreshHeader( ClassicsHeader(mActivity));
//设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter( ClassicsFooter(mActivity));
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_mine
    }
}