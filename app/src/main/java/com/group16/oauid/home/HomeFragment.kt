package com.group16.oauid.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.group16.oauid.BottomNavTopLevelFragment
import com.group16.oauid.MainActivity
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return

        val student = MainActivity.loggedIn

        binding.name.text = MainActivity.loggedIn.name.split(" ")[0]
        binding.basicDetails.text = resources.getString(
            R.string.basic_details,
            student.name,
            student.sex,
            student.faculty,
            student.department
        )
        binding.passport.setImageResource(student.image)

        binding.replaceId.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToReplacementFragment())
        }

        binding.getId.setOnClickListener {
            if (sharedPref.getBoolean(student.matricNum, false)) {
                Toast.makeText(
                    requireContext(),
                    "You have already generated an ID card this session, Click the Replace ID instead",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToGetFragment())
            }
        }
    }
}