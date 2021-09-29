package com.example.androidportfolio.staggeredgridcolors

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseFragment
import com.example.androidportfolio.databinding.StaggeredGirdColorsFragmentBinding
import com.example.androidportfolio.util.viewBinding

class StaggeredGridColorsFragment : BaseFragment(R.layout.staggered_gird_colors_fragment) {
    private val binding by viewBinding(StaggeredGirdColorsFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

    override fun onDestroyView() {
        binding.staggeredGridColor.adapter = null
        super.onDestroyView()
    }
}
