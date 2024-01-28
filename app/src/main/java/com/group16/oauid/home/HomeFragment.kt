package com.group16.oauid.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.group16.oauid.BottomNavTopLevelFragment
import com.group16.oauid.R
import com.group16.oauid.databinding.FragmentHomeBinding
import com.group16.oauid.viewBinding

class HomeFragment : BottomNavTopLevelFragment() {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}