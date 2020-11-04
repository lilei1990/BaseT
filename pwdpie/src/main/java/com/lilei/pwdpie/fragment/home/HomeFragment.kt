package com.lilei.pwdpie.fragment.home

import android.os.Bundle
import com.lei.base_core.base.BaseVmFragment
import com.lilei.pwdpie.R
import com.lilei.pwdpie.databinding.FragmentHomeBinding
import com.lilei.pwdpie.databinding.FragmentMainBinding
import com.lilei.pwdpie.databinding.FragmentMineBinding

class HomeFragment : BaseVmFragment<FragmentHomeBinding>() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun init(savedInstanceState: Bundle?) {
        mBinding.content = "我是主fragment"
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }


}