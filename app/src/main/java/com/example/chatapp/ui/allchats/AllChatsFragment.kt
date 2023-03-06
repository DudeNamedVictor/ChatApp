package com.example.chatapp.ui.allchats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chatapp.databinding.AllChatsFrragmentLayoutBinding

class AllChatsFragment : Fragment() {

    private var _binding: AllChatsFrragmentLayoutBinding? = null
    private val binding: AllChatsFrragmentLayoutBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = AllChatsFrragmentLayoutBinding.inflate(inflater, container, false)

        return binding.root
    }

}