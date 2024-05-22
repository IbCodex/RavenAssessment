package com.example.assessmentraven.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.assessmentraven.ChartsFragment
import com.example.assessmentraven.OrderBlockFragment
import com.example.assessmentraven.RecentsTradeFragment

class ChartsViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment)  {

    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> ChartsFragment()
            1 -> OrderBlockFragment()
            2 -> RecentsTradeFragment()
            else -> RecentsTradeFragment()
        }
    }

}