package com.example.chatapp.ui.allchats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
            title = null,
            onLeftIconClick = {

            },
            onRightIconClick = {

            })
    }

}