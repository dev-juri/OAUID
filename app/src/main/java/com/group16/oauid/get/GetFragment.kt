package com.group16.oauid.get

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.group16.oauid.BaseFragment
import com.group16.oauid.R
import com.group16.oauid.createAndDownloadPdf
import com.group16.oauid.databinding.FragmentGetBinding
import com.group16.oauid.viewBinding

class GetFragment: BaseFragment() {

    private val binding by viewBinding(FragmentGetBinding::bind)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_get, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.print.setOnClickListener {
            Log.d("file", createAndDownloadPdf(binding.idView).toString())
        }
    }
}