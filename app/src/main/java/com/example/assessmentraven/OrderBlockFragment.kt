package com.example.assessmentraven

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assessmentraven.adapters.CurrencyAdapter
import com.example.assessmentraven.adapters.CurrencyTwonAdapter
import com.example.assessmentraven.utils.Constants
import com.example.assessmentraven.databinding.FragmentOrderBlockBinding

class OrderBlockFragment : Fragment() {
  private var _binding: FragmentOrderBlockBinding? = null
    private val binding get() = _binding!!
    private val tabStateViewModel: TabStateViewModel by activityViewModels()
    lateinit var currencyAdapter: CurrencyAdapter
    lateinit var currencyTwonAdapter: CurrencyTwonAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOrderBlockBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        currencyAdapter = CurrencyAdapter{
            tabStateViewModel.dataBundle = it
        }

        currencyTwonAdapter = CurrencyTwonAdapter{
            tabStateViewModel.dataBundles = it
        }


        binding.recyclerView.apply {
            adapter = currencyAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false
            )
        }
        currencyAdapter.submitList(Constants.dataBundle)


        binding.recyclerViewNew.apply {
            adapter = currencyTwonAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false
            )
        }
        currencyTwonAdapter.submitList(Constants.dataBundles)

    }

}