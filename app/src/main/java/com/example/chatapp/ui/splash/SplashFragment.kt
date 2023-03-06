package com.example.chatapp.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.chatapp.databinding.SplashFragmentLayoutBinding

class SplashFragment : Fragment() {

    private var _binding: SplashFragmentLayoutBinding? = null
    private val binding: SplashFragmentLayoutBinding
        get() = _binding!!
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SplashFragmentLayoutBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.stateMLD.observe(viewLifecycleOwner) {
            when (it) {
                SplashViewModel.SplashScreenState.LoginSuccess -> {
                    // todo: переход на экран чатов
                }
                SplashViewModel.SplashScreenState.LoginFailed -> {
                    // todo: переход на экран логина
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}