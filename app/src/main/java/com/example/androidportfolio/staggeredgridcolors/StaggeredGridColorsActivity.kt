package com.example.androidportfolio.staggeredgridcolors

import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseActivity
import kotlinx.android.synthetic.main.activity_staggered_grid_colors.*

class StaggeredGridColorsActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_staggered_grid_colors)

    val list = listOf(
      "A",
      "B",
      "C",
      "D",
      "E",
      "F",
      "G",
      "H",
      "I",
      "J",
      "K",
      "L",
      "M",
      "N"
    )

    val staggeredGridLayoutManager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
    //staggeredGridLayoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS

    staggered_grid_color.layoutManager = staggeredGridLayoutManager
    val adapter = StaggeredGridColorsAdapter(list)
    staggered_grid_color.adapter = adapter

    setUp()
  }
}
