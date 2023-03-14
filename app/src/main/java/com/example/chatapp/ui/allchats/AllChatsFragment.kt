package com.example.chatapp.ui.allchats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.chatapp.R
import com.example.chatapp.databinding.AllChatsFragmentLayoutBinding

class AllChatsFragment : Fragment() {

    private var _binding: AllChatsFragmentLayoutBinding? = null
    private val binding: AllChatsFragmentLayoutBinding
        get() = _binding!!
    private val viewModel: AllChatsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = AllChatsFragmentLayoutBinding.inflate(inflater, container, false)
        initToolbar()
        initViews()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initToolbar() {
        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    findNavController().navigate(R.id.action_allChatsFragment_to_globalSettingsFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun initViews() {
        binding.addPeople.setOnClickListener {
            findNavController().navigate(R.id.action_allChatsFragment_to_searchUserFragment)
        }
    }

}