package com.example.chatapp.ui.allchats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.chatapp.R
import com.example.chatapp.databinding.AllChatsFragmentLayoutBinding
import com.example.chatapp.ui.views.CustomToolbar

class AllChatsFragment : Fragment() {

    private var _binding: AllChatsFragmentLayoutBinding? = null
    private val binding: AllChatsFragmentLayoutBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = AllChatsFragmentLayoutBinding.inflate(inflater, container, false)
        initToolbar()

        return binding.root
    }

    private fun initToolbar() {
        binding.toolbar.populate(
            toolbarType = CustomToolbar.ToolbarType.ALL_CHATS,
            onLeftIconClick = {
                findNavController().navigate(R.id.action_allChatsFragment_to_searchUserFragment)
            },
            onRightIconClick = {
                findNavController().navigate(R.id.action_allChatsFragment_to_globalSettingsFragment)
            })
    }

}