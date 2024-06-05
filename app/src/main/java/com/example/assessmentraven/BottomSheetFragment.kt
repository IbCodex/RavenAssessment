package com.example.assessmentraven

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.assessmentraven.adapters.AvailableOptionsAdapter
import com.example.assessmentraven.adapters.NumberOptionsAdapter
import com.example.assessmentraven.databinding.FragmentBottomSheetBinding


class BottomSheetFragment : Fragment() {
 private var _binding: FragmentBottomSheetBinding? = null
    private val binding get() = _binding!!
    private val tabDetails = arrayListOf("Buy", "Sell" )
    private val tabStateViewModel : TabStateViewModel by activityViewModels()
    lateinit var availableOptionsAdapter: AvailableOptionsAdapter
    lateinit var numberOptionsAdapter: NumberOptionsAdapter

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


        availableOptionsAdapter = AvailableOptionsAdapter(requireContext())
        binding.genderSpinner.adapter = availableOptionsAdapter


        numberOptionsAdapter = NumberOptionsAdapter(requireContext())
        binding.currency.adapter = numberOptionsAdapter



        binding.buyNow.setOnClickListener {
            binding.buyNow.setBackgroundResource(R.drawable.bg_selected)
            binding.buyNow.setBackgroundResource(0)
        }

        binding.sellNow.setOnClickListener {
            binding.sellNow.setBackgroundResource(R.drawable.bg_selected)
            binding.sellNow.setBackgroundResource(0)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}