package com.group16.oauid.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.group16.oauid.BaseFragment
import com.group16.oauid.MainActivity
import com.group16.oauid.R
import com.group16.oauid.databinding.FragmentLoginBinding
import com.group16.oauid.viewBinding

class LoginFragment : BaseFragment() {

    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signIn.setOnClickListener {
            val matricNo = binding.matricNo.editText?.text.toString().trim()
            val password = binding.password.editText?.text.toString().trim()

            if (matricNo.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "No field should be left blank.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val student =
                    MainActivity.studentDatabase.find { it.matricNum == matricNo && it.password == password }
                if (student != null) {
                    MainActivity.loggedIn = student
                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Student with the provided details isn't registered for the current session.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }
}