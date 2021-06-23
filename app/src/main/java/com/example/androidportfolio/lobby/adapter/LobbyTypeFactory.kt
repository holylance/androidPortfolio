package com.example.androidportfolio.lobby.adapter

import android.view.ViewGroup
import com.example.androidportfolio.R
import com.example.androidportfolio.databinding.LobbyLabelItemBinding
import com.example.androidportfolio.lobby.model.LobbyLabelItem
import com.example.androidportfolio.lobby.viewholder.LobbyViewHolder
import com.example.androidportfolio.uilibrary.listadapter.BindingViewHolder
import com.example.androidportfolio.uilibrary.listadapter.ListItemModel
import com.example.androidportfolio.uilibrary.listadapter.ListItemTypeFactory

class LobbyTypeFactory : ListItemTypeFactory {

    override fun type(item: ListItemModel): Int {
        return when (item) {
            is LobbyLabelItem -> R.layout.lobby_label_item
            else -> error("Invalid type")
        }
    }

    override fun createViewHolder(parent: ViewGroup, type: Int): BindingViewHolder<*, *> {
        return when (type) {
            R.layout.lobby_label_item -> LobbyViewHolder(
                createBinding(LobbyLabelItemBinding::inflate, parent)
            )
            else -> error("Invalid layout")
        }
    }
}
