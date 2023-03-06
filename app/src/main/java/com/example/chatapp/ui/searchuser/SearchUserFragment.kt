package com.example.chatapp.ui.searchuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.chatapp.databinding.SearchUserLayoutBinding
import com.example.chatapp.ui.views.CustomToolbar

class SearchUserFragment : Fragment() {

    private var _binding: SearchUserLayoutBinding? = null
    private val binding: SearchUserLayoutBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SearchUserLayoutBinding.inflate(inflater, container, false)
        initToolbar()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initToolbar() {
        binding.toolbar.populate(
            toolbarType = CustomToolbar.ToolbarType.SEARCH,
            onLeftIconClick = {
                findNavController().popBackStack()
            })
    }

}