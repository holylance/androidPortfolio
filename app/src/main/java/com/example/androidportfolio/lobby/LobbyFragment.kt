package com.example.androidportfolio.lobby

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseFragment
import com.example.androidportfolio.databinding.LobbyFragmentBinding
import com.example.androidportfolio.lobby.adapter.LobbyTypeFactory
import com.example.androidportfolio.lobby.model.LobbyItem
import com.example.androidportfolio.lobby.model.LobbyItem.Action
import com.example.androidportfolio.recycleview.RecycleViewBasicActivity
import com.example.androidportfolio.scrollviewwithkeyboard.ScrollviewWithKeyboardActivity
import com.example.androidportfolio.staggeredgridcolors.StaggeredGridColorsActivity
import com.example.androidportfolio.uilibrary.listadapter.ListItemAction
import com.example.androidportfolio.uilibrary.listadapter.ListItemAdapter
import com.example.androidportfolio.util.viewBinding
import com.example.androidportfolio.weatherHttpResopnse.WeatherHttpResponseActivity

class LobbyFragment : BaseFragment(R.layout.lobby_fragment) {

    private val binding by viewBinding(LobbyFragmentBinding::bind)
    private val adapter = ListItemAdapter<LobbyItem, ListItemAction>(
        typeFactory = LobbyTypeFactory(),
        primaryAction = ::onItemClick
    )
    private val viewModel = LobbyViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.setItems(viewModel.createItems())
        binding.listFragments.adapter = adapter
    }

    override fun onDestroyView() {
        binding.listFragments.adapter = null
        super.onDestroyView()
    }

    private fun onItemClick(data: LobbyItem) {
        when (data.action) {
            Action.MY_CAREERS -> Unit
            else -> Unit
        }
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
            }
            startActivity(intent)
        }
    }

    companion object {
        enum class ActivityType(
            val typeName: String
        ) {
            RecycleViewBasic("RecycleViewBasic"),
            ScrollviewWithKeyboard("ScrollviewWithKeyboard"),
            StaggeredGridColors("StaggeredGridColors"),
            WeatherHttpResponse("WeatherHttpResponse"),
        }
    }
}
