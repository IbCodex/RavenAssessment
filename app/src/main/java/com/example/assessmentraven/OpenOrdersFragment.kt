package com.example.assessmentraven

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.assessmentraven.databinding.FragmentOpenOrdersBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


class OpenOrdersFragment : Fragment() {
private var _binding: FragmentOpenOrdersBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOpenOrdersBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialogTheme)
        val bottomSheetView = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_bottom_sheet, null)
        bottomSheetDialog.setContentView(bottomSheetView)


        binding.buyNow.setOnClickListener {

        }

        binding.buyNow.setOnClickListener {
            bottomSheetDialog.show()
        }
    }
}