package com.lilei.pwdpie.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.lei.base_core.base.BaseVmFragment
import com.lei.base_core.base.DataBindingConfig
import com.lei.base_core.common.initFragment
import com.lilei.pwdpie.R
import com.lilei.pwdpie.databinding.FragmentMainBinding
import com.lilei.pwdpie.fragment.home.HomeFragment
import com.lilei.pwdpie.fragment.mine.MineFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseVmFragment<FragmentMainBinding>() {
    private val fragmentList = arrayListOf<Fragment>()
    private val homeFragment by lazy { HomeFragment() }
    private val mineFragment by lazy { MineFragment() }
    companion object {
        fun newInstance() = MainFragment()
    }
    init {
        fragmentList.apply {
            add(homeFragment)
            add(mineFragment)
        }
    }
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun init(savedInstanceState: Bundle?) {
        //初始化viewpager2
        vpHome.initFragment(this, fragmentList).run {
            //全部缓存,避免切换回重新加载
            offscreenPageLimit = fragmentList.size
        }
        //取消viewPager2滑动
        vpHome.isUserInputEnabled = false
        vpHome.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                btnNav.menu.getItem(position).isChecked = true
            }
        })
        //初始化底部导航栏
        btnNav.run {
            setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_home -> vpHome.setCurrentItem(0, false)
                    R.id.menu_mine -> vpHome.setCurrentItem(1, false)
                }
                // 这里注意返回true,否则点击失效
                true
            }
        }
        val rv = vpHome[0] as RecyclerView
        rv.isNestedScrollingEnabled = false

    }

    override fun getLayoutId(): Int {
      return R.layout.fragment_main
    }


//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

}