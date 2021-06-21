package com.example.androidportfolio.recycleview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseActivity
import com.example.androidportfolio.databinding.ActivityListItemBinding
import com.example.androidportfolio.util.viewBinding

class ListItemActivity : BaseActivity(R.layout.activity_list_item) {

    private val binding by viewBinding(ActivityListItemBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (intent.hasExtra(RecycleViewBasicActivity.strTextDetail)) {
            binding.textViewDetail.text = intent.getStringExtra(RecycleViewBasicActivity.strTextDetail)
        }

        binding.buttonDetail.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result", binding.textViewDetail.text)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
