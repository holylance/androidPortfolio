package com.example.androidportfolio.lobby

import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseViewModel
import com.example.androidportfolio.lobby.model.LobbyItem
import com.example.androidportfolio.lobby.model.LobbyItem.Action
import com.example.androidportfolio.lobby.model.LobbyLabelItem

class LobbyViewModel : BaseViewModel() {

    fun createItems(): List<LobbyItem> {
        return listOf(
            LobbyLabelItem(
                icon = R.drawable.ic_my_careers,
                title = R.string.app_bar_my_careers,
                subtitle = R.string.app_bar_my_careers,
                action = Action.MY_CAREERS
            ),
            LobbyLabelItem(
                icon = R.drawable.ic_staggered_grid_colors,
                title = R.string.app_bar_staggered_grid_colors,
                subtitle = R.string.app_bar_staggered_grid_colors,
                action = Action.STAGGERED_GRID_COLOR
            )
        )
    }
}
