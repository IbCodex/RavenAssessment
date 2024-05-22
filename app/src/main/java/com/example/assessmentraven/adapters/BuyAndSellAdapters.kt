package com.example.assessmentraven.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.assessmentraven.*

class BuyAndSellAdapters(fragment: Fragment): FragmentStateAdapter(fragment)  {

    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> BuyFragment()
            1 -> SellFragment()
            else -> SellFragment()
        }
    }

}