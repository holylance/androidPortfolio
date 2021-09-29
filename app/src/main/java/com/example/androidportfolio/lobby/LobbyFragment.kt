package com.example.androidportfolio.lobby

import android.os.Bundle
import android.view.View
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseFragment
import com.example.androidportfolio.databinding.LobbyFragmentBinding
import com.example.androidportfolio.lobby.adapter.LobbyTypeFactory
import com.example.androidportfolio.lobby.model.LobbyItem
import com.example.androidportfolio.lobby.model.LobbyItem.Action
import com.example.androidportfolio.uilibrary.listadapter.ListItemAction
import com.example.androidportfolio.uilibrary.listadapter.ListItemAdapter
import com.example.androidportfolio.util.viewBinding

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
            Action.MY_CAREERS -> safeNavigate(R.id.to_my_careers_fragment)
            Action.STAGGERED_GRID_COLOR -> safeNavigate(R.id.to_staggered_grid_colors_fragment)
            Action.WEATHER_API_CLIENT -> Unit
            else -> Unit
        }
    }
}
