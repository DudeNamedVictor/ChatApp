package com.example.chatapp.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.chatapp.R
import com.example.chatapp.databinding.CustomToolbarLayoutBinding

class CustomToolbar(
    context: Context,
    attributeSet: AttributeSet,
) : LinearLayout(context, attributeSet) {

    private var binding = CustomToolbarLayoutBinding.inflate(
        LayoutInflater.from(context),
        this,
    )

    init {
        binding.root.background = ContextCompat.getDrawable(context, R.color.purple_700)
    }

    fun populate(
        toolbarType: ToolbarType,
        title: String? = null,
        onLeftIconClick: ((Unit) -> Unit)? = null,
        onRightIconClick: ((Unit) -> Unit)? = null,
    ) {
        when (toolbarType) {
            ToolbarType.AUTHORIZATION -> {
                binding.leftIcon.isVisible = false
                binding.rightIcon.isVisible = false
                binding.title.setText(R.string.authorization)
            }
            ToolbarType.ALL_CHATS -> {
                binding.leftIcon.setImageDrawable(ContextCompat.getDrawable(context,
                    R.drawable.ic_baseline_search_32))
                binding.title.setText(R.string.all_chats)
            }
            ToolbarType.CURRENT_CHAT -> {
                binding.title.text = title
            }
            ToolbarType.SETTINGS -> {
                binding.rightIcon.isVisible = false
                binding.title.setText(R.string.settings)
            }
        }

        binding.leftIcon.setOnClickListener {
            onLeftIconClick?.invoke(Unit)
        }
        binding.rightIcon.setOnClickListener {
            onRightIconClick?.invoke(Unit)
        }
    }

    enum class ToolbarType {
        AUTHORIZATION, ALL_CHATS, CURRENT_CHAT, SETTINGS
    }

}