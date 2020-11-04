package com.lilei.pwdpie.fragment.mine

import android.os.Bundle
import com.lei.base_core.base.BaseVmFragment
import com.lilei.pwdpie.R
import com.lilei.pwdpie.databinding.FragmentHomeBinding
import com.lilei.pwdpie.databinding.FragmentMineBinding

class MineFragment : BaseVmFragment<FragmentHomeBinding>() {

    companion object {
        fun newInstance() = MineFragment()
    }



    override fun init(savedInstanceState: Bundle?) {
        mBinding.content = "这是我的界面"
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }
}