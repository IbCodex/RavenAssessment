package com.example.assessmentraven

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assessmentraven.adapters.ChartsViewPagerAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.example.assessmentraven.adapters.ChartsViewPagerAdapterTwo
import com.example.assessmentraven.databinding.FragmentHomeBinding
import com.example.assessmentraven.utils.statusBarColor
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val tabTitles = arrayListOf("Charts", "Orderbook", "Recent trades")
    private val tabTitle = arrayListOf("Open Orders", "Positions")
    private val tabStateViewModel: TabStateViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        statusBarColor()
        setUpTabLayoutWitViewPager()
        setUpTabLayoutWitViewPagerr()





        binding.buyNow.setOnClickListener {
            showBottomSheet()
        }

        lifecycleScope.launch {
            tabStateViewModel.airtimeDataTabState.collect {
                val tab = binding.tab.getTabAt(it)
                tab?.select()
                binding.viewpager.setCurrentItem(it, false)
            }
        }


        lifecycleScope.launch {
            tabStateViewModel.utilityElectricityTabState.collect {
                val tab = binding.tablet.getTabAt(it)
                tab?.select()
                binding.viewpager2.setCurrentItem(it, false)
            }
        }

    }

    private fun setUpTabLayoutWitViewPager() {
        binding.viewpager.adapter = ChartsViewPagerAdapter(this)
        TabLayoutMediator(
            binding.tab,
            binding.viewpager
        ) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()


        binding.tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    tabStateViewModel.setAirtimeProvider(tab.position)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })


    }


    private fun setUpTabLayoutWitViewPagerr() {
        binding.viewpager2.adapter = ChartsViewPagerAdapterTwo(this)
        TabLayoutMediator(
            binding.tablet,
            binding.viewpager2
        ) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()


        binding.tablet.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    tabStateViewModel.setUtilityTabState(tab.position)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }


    private fun showBottomSheet() {
        val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        val bottomSheetView =
            LayoutInflater.from(requireContext()).inflate(R.layout.fragment_bottom_sheet, null)
        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
