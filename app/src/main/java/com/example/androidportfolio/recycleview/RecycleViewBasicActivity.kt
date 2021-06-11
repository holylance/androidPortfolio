package com.example.androidportfolio.recycleview

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseActivity
import kotlinx.android.synthetic.main.activity_recycle_view_basic.*

class RecycleViewBasicActivity : BaseActivity() {
  companion object {
    const val strTextDetail = "textDetail"
    const val nRequestTypeNoResult = 1000
  }

  inner class ItemClickListener(
    private val context: Context
  ): RecycleViewBasicAdapter.OnItemClickListener {
    override fun onItemClick(item: String) {
      val intent = Intent(context, ListItemActivity::class.java)
      intent.putExtra(strTextDetail, item)
      startActivityForResult(intent, nRequestTypeNoResult)
    }
  }

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
    val adapter = RecycleViewBasicAdapter(list, ItemClickListener(this))
    recyclerView.adapter = adapter

    setUp()
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)

    when (requestCode) {
      nRequestTypeNoResult -> if (resultCode == Activity.RESULT_OK) {
        if (data != null) {
          Toast.makeText(this, data.getStringExtra("result"), Toast.LENGTH_SHORT).show()
        }
      }
    }
  }
}
