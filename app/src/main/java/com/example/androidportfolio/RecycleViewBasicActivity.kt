package com.example.androidportfolio

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycle_view_basic.*

class RecycleViewBasicActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_recycle_view_basic)

    var list = listOf<String>()
    for (i in 0..99) {
      list += String.format("TEXT %d", i)
    }

    // 리사이클러뷰에 LinearLayoutManager 객체 지정.
    recyclerView.layoutManager = LinearLayoutManager(this)

    // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
    val adapter = RecycleViewBasicAdapter(list)
    recyclerView.adapter = adapter
  }
}
