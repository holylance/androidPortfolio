package com.example.androidportfolio.lobby.model

import androidx.annotation.DrawableRes
import com.example.androidportfolio.uilibrary.listadapter.ListItemModel
import com.example.androidportfolio.uilibrary.listadapter.ListItemTypeFactory

interface LobbyItem : ListItemModel {
    val action: Action

    enum class Action {
        NONE,
        MY_CAREERS,
        STAGGERED_GRID_COLOR,
        WEATHER_API_CLIENT
    }
}

data class LobbyLabelItem(
    @DrawableRes val icon: Int,
    val title: Int,
    val subtitle: Int? = null,
    override val action: LobbyItem.Action
) : LobbyItem {
    override fun type(typeFactory: ListItemTypeFactory) = typeFactory.type(this)
}
