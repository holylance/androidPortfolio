package com.example.androidportfolio.lobby

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseFragment
import com.example.androidportfolio.databinding.LobbyFragmentBinding
import com.example.androidportfolio.myCareers.MyCareersActivity
import com.example.androidportfolio.recycleview.RecycleViewBasicActivity
import com.example.androidportfolio.scrollviewwithkeyboard.ScrollviewWithKeyboardActivity
import com.example.androidportfolio.staggeredgridcolors.StaggeredGridColorsActivity
import com.example.androidportfolio.util.viewBinding
import com.example.androidportfolio.weatherHttpResopnse.WeatherHttpResponseActivity

class LobbyFragment : BaseFragment(R.layout.lobby_fragment) {

    private val binding by viewBinding(LobbyFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ActivityType.values().map { it.typeName }

        binding.listFragments.layoutManager = LinearLayoutManager(activity)
        val adapter = LobbyAdapter(list, ItemClickListener(requireContext()))
        binding.listFragments.adapter = adapter
    }

    override fun onDestroyView() {
        binding.listFragments.adapter = null
        super.onDestroyView()
    }

    inner class ItemClickListener(
        private val context: Context
    ) : LobbyAdapter.OnItemClickListener {
        override fun onItemClick(item: String) {
            val intent = when (ActivityType.valueOf(item)) {
                ActivityType.RecycleViewBasic -> Intent(
                    context,
                    RecycleViewBasicActivity::class.java
                )
                ActivityType.ScrollviewWithKeyboard -> Intent(
                    context,
                    ScrollviewWithKeyboardActivity::class.java
                )
                ActivityType.StaggeredGridColors -> Intent(
                    context,
                    StaggeredGridColorsActivity::class.java
                )
                ActivityType.WeatherHttpResponse -> Intent(
                    context,
                    WeatherHttpResponseActivity::class.java
                )
                else -> Intent(context, MyCareersActivity::class.java)
            }
            startActivity(intent)
        }
    }

    companion object {
        enum class ActivityType(
            val typeName: String
        ) {
            MyCareers("MyCareers"),
            RecycleViewBasic("RecycleViewBasic"),
            ScrollviewWithKeyboard("ScrollviewWithKeyboard"),
            StaggeredGridColors("StaggeredGridColors"),
            WeatherHttpResponse("WeatherHttpResponse"),
        }
    }
}
