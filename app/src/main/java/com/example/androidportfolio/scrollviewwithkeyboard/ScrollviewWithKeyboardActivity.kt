package com.example.androidportfolio.scrollviewwithkeyboard

import android.os.Bundle
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseActivity
import kotlinx.android.synthetic.main.activity_scrollview_with_keyboard.*

class ScrollviewWithKeyboardActivity : BaseActivity() {
  private lateinit var keyboardUtil: KeyboardUtil

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_scrollview_with_keyboard)

    setUp()

    keyboardUtil = KeyboardUtil(
      window,
      onShowKeyboard = { keyboardHeight ->
        sv_root.run {
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
