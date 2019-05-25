package com.example.androidportfolio

import android.os.Bundle
import com.example.androidportfolio.base.BaseActivity
import kotlinx.android.synthetic.main.activity_instance_state_and_keyboard.*

class InstanceStateAndKeyboardActivity : BaseActivity() {
  companion object {
    private const val KEY_COUNT: String = "count"
    private const val KEY_EDIT: String = "edit"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_instance_state_and_keyboard)

    // init text.
    text_view_count.text = "0"

    button_plus.setOnClickListener {
      var nCount = text_view_count.text.toString().toInt()
      nCount += 1
      text_view_count.text = nCount.toString()
    }

    setUp()

    savedInstanceState?.let {
      text_view_count.text = savedInstanceState.getString(KEY_COUNT)
      edit_instance_state.setText(savedInstanceState.getString(KEY_EDIT))
    }
  }

  override fun onSaveInstanceState(outState: Bundle?) {
    super.onSaveInstanceState(outState)

    outState?.let {
      outState.putString(KEY_COUNT, text_view_count.text.toString())
      outState.putString(KEY_EDIT, edit_instance_state.text.toString())
    }
  }
}
