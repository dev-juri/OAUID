package com.group16.oauid.replacement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.group16.oauid.BaseFragment
import com.group16.oauid.R
import com.group16.oauid.databinding.FragmentSuccessBinding
import com.group16.oauid.viewBinding

class SuccessFragment : BaseFragment() {

    private val binding by viewBinding(FragmentSuccessBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_success, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.print.setOnClickListener {
            Toast.makeText(requireContext(), "Card Printing...", Toast.LENGTH_LONG).show()
        }
    }
}