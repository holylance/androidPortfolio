package com.example.androidportfolio.lobby.viewholder

import com.example.androidportfolio.databinding.LobbyLabelItemBinding
import com.example.androidportfolio.lobby.model.LobbyLabelItem
import com.example.androidportfolio.uilibrary.listadapter.BindingViewHolder
import com.example.androidportfolio.uilibrary.listadapter.ListItemAction
import com.example.androidportfolio.util.getString

class LobbyViewHolder(
    private val binding: LobbyLabelItemBinding
) : BindingViewHolder<LobbyLabelItem, ListItemAction>(binding.root) {

    override fun bind(item: LobbyLabelItem, primaryAction: (LobbyLabelItem) -> Unit) {
        binding.root.setOnClickListener { primaryAction.invoke(item) }

        binding.moreItem.apply {
            setIcon(item.icon)
            setTitle(resources.getString(item.title))
            setSubtitle(resources.getString(item.subtitle))
        }
    }
}
