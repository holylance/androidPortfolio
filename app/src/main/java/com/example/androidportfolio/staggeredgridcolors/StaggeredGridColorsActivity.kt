package com.example.androidportfolio.staggeredgridcolors

import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseActivity
import com.example.androidportfolio.databinding.ActivityStaggeredGridColorsBinding
import com.example.androidportfolio.util.viewBinding

class StaggeredGridColorsActivity : BaseActivity(R.layout.activity_staggered_grid_colors) {

    private val binding by viewBinding(ActivityStaggeredGridColorsBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        val staggeredGridLayoutManager =
            StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
        //staggeredGridLayoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS

        binding.staggeredGridColor.layoutManager = staggeredGridLayoutManager
        val adapter = StaggeredGridColorsAdapter(list)
        binding.staggeredGridColor.adapter = adapter
    }
}
