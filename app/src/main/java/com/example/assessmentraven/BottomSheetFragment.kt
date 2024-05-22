package com.example.assessmentraven

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.assessmentraven.adapters.BuyAndSellAdapters
import com.example.assessmentraven.adapters.ChartsViewPagerAdapterTwo
import com.example.assessmentraven.databinding.FragmentBottomSheetBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch


class BottomSheetFragment : Fragment() {
 private var _binding: FragmentBottomSheetBinding? = null
    private val binding get() = _binding!!
    private val tabTitle = arrayListOf("Buy", "Sell" )
    private val tabStateViewModel : TabStateViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBottomSheetBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpTabLayoutWitViewPaggerr()

        lifecycleScope.launch{
            tabStateViewModel.viewPagerTwoTabState.collect{
                val tab = binding.tabletSell.getTabAt(it)
                tab?.select()
                binding.viewpager2Seller.setCurrentItem(it,false)
            }
        }
    }

    private fun setUpTabLayoutWitViewPaggerr() {
        binding.viewpager2Seller.adapter = BuyAndSellAdapters(this)
        TabLayoutMediator(
            binding.tabletSell,
            binding.viewpager2Seller
        ) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()


        binding.tabletSell.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    tabStateViewModel.setRewardsViewPager(tab.position)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }
}