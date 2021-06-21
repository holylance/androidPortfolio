package com.example.androidportfolio.scrollviewwithkeyboard

import android.os.Bundle
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseActivity
import com.example.androidportfolio.databinding.ActivityScrollviewWithKeyboardBinding
import com.example.androidportfolio.util.viewBinding

class ScrollviewWithKeyboardActivity : BaseActivity(R.layout.activity_scrollview_with_keyboard) {

    private val binding by viewBinding(ActivityScrollviewWithKeyboardBinding::bind)
    private lateinit var keyboardUtil: KeyboardUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        keyboardUtil = KeyboardUtil(
            window,
            onShowKeyboard = { keyboardHeight ->
                binding.svRoot.run {
                    smoothScrollTo(scrollX, scrollY + keyboardHeight)
                }
            }
        )
    }

    override fun onDestroy() {
        keyboardUtil.detachKeyboardListeners()
        super.onDestroy()
    }
}
