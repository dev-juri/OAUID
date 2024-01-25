package com.group16.oauid.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.group16.oauid.R
import com.group16.oauid.databinding.FragmentLoginBinding
import com.group16.oauid.viewBinding

class LoginFragment : Fragment() {

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
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeActivity())
        }
    }
}