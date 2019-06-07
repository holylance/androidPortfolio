package com.example.androidportfolio.staggeredgridcolors

import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseActivity
import kotlinx.android.synthetic.main.activity_staggered_grid_colors.*

class StaggeredGridColorsActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_staggered_grid_colors)

    val list = listOf(
      "Red",
      "Green",
      "Blue",
      "Yellow",
      "Magenta",
      "Cyan",
      "Orange",
      "Aqua",
      "Azure",
      "Beige",
      "Bisque",
      "Brown",
      "Coral",
      "Crimson"
    )

    val staggeredGridLayoutManager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
    //staggeredGridLayoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS

    staggered_grid_color.layoutManager = staggeredGridLayoutManager
    val adapter = StaggeredGridColorsAdapter(list)
    staggered_grid_color.adapter = adapter

    setUp()
  }
}
