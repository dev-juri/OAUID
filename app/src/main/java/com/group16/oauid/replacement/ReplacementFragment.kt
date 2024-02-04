package com.group16.oauid.replacement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.group16.oauid.BaseFragment
import com.group16.oauid.R
import com.group16.oauid.databinding.FragmentReplacementBinding
import com.group16.oauid.viewBinding

class ReplacementFragment : BaseFragment() {

    private val binding by viewBinding(FragmentReplacementBinding::bind)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_replacement, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.pay.setOnClickListener {
            findNavController().navigate(ReplacementFragmentDirections.actionReplacementFragmentToSuccessFragment())
        }
    }
}