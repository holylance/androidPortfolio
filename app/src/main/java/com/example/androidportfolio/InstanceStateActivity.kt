package com.example.androidportfolio

import android.os.Bundle
import android.os.PersistableBundle
import com.example.androidportfolio.base.BaseActivity
import com.example.androidportfolio.databinding.ActivityInstanceStateBinding
import com.example.androidportfolio.util.viewBinding

class InstanceStateActivity : BaseActivity(R.layout.activity_instance_state) {

    private val binding by viewBinding(ActivityInstanceStateBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // init text.
        binding.textViewCount.text = "0"

        binding.buttonPlus.setOnClickListener {
            var nCount = binding.textViewCount.text.toString().toInt()
            nCount += 1
          binding.textViewCount.text = nCount.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)

        outState.let {
            outState.putString(KEY_COUNT, binding.textViewCount.text.toString())
            outState.putString(KEY_EDIT, binding.editInstanceState.text.toString())
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        savedInstanceState?.let {
            binding.textViewCount.text = savedInstanceState.getString(KEY_COUNT)
            binding.editInstanceState.setText(savedInstanceState.getString(KEY_EDIT))
        }
    }

    companion object {
        private const val KEY_COUNT: String = "count"
        private const val KEY_EDIT: String = "edit"
    }
}
