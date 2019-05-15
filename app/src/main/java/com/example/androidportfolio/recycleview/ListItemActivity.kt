package com.example.androidportfolio.recycleview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.androidportfolio.R
import kotlinx.android.synthetic.main.activity_list_item.*

class ListItemActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list_item)

    if (intent.hasExtra(RecycleViewBasicActivity.strTextDetail)) {
      textViewDetail.text = intent.getStringExtra(RecycleViewBasicActivity.strTextDetail)
    }
  }
}
