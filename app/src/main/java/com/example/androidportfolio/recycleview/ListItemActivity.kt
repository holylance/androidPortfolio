package com.example.androidportfolio.recycleview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseActivity
import kotlinx.android.synthetic.main.activity_list_item.*

class ListItemActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list_item)

    if (intent.hasExtra(RecycleViewBasicActivity.strTextDetail)) {
      textViewDetail.text = intent.getStringExtra(RecycleViewBasicActivity.strTextDetail)
    }

    buttonDetail.setOnClickListener {
      val intent = Intent()
      intent.putExtra("result", textViewDetail.text)
      setResult(Activity.RESULT_OK, intent)
      finish()
    }

    setUp()
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    //supportActionBar?.setDisplayShowHomeEnabled(true)
  }
}
