package com.example.chatapp.ui.globalsettings

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.chatapp.MainActivity
import com.example.chatapp.R
import com.example.chatapp.databinding.GlobalSettingsFragmentBinding

const val PREFS_NAME = "theme_prefs"
const val KEY_THEME = "prefs.theme"

class GlobalSettingsFragment : Fragment() {

    private var _binding: GlobalSettingsFragmentBinding? = null
    private val binding: GlobalSettingsFragmentBinding
        get() = _binding!!
    private val sharedPreferences by lazy {
        activity?.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = GlobalSettingsFragmentBinding.inflate(inflater, container, false)
        initToolbar()
        chooseTheme()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun chooseTheme() {
        binding.theme.apply {
            redTheme.setOnClickListener { setTheme(R.style.Theme_ChatAppRed) }
            greenTheme.setOnClickListener { setTheme(R.style.Theme_ChatAppGreen) }
            blueTheme.setOnClickListener { setTheme(R.style.Theme_ChatAppBlue) }
            defaultTheme.setOnClickListener { setTheme(R.style.Theme_ChatAppDefault) }
            nightTheme.setOnClickListener { setTheme(R.style.Theme_ChatAppNight) }
        }
    }

    private fun setTheme(theme: Int) {
        sharedPreferences?.edit {
            putInt(KEY_THEME, theme).apply()
            (activity as MainActivity).recreateActivity()
        }
    }

}