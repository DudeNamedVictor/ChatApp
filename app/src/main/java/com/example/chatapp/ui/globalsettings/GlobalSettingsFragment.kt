package com.example.chatapp.ui.globalsettings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.chatapp.databinding.GlobalSettingsFragmentBinding
import com.example.chatapp.ui.views.CustomToolbar

class GlobalSettingsFragment : Fragment() {

    private var _binding: GlobalSettingsFragmentBinding? = null
    private val binding: GlobalSettingsFragmentBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = GlobalSettingsFragmentBinding.inflate(inflater, container, false)
        initToolbar()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initToolbar() {
        binding.toolbar.populate(
            toolbarType = CustomToolbar.ToolbarType.SETTINGS,
            onLeftIconClick = {
                findNavController().popBackStack()
            })
    }

}