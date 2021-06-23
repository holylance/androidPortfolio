package com.example.androidportfolio.uilibrary.listadapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Layout manager that expands the last item to fill available space if the item's type is one of
 * the provided types.
 */
class LastItemExpandingLayoutManager(
    context: Context,
    private val expandTypes: List<Int>
) : LinearLayoutManager(context) {

    override fun layoutDecoratedWithMargins(
        child: View,
        left: Int,
        top: Int,
        right: Int,
        bottom: Int
    ) {
        val params = child.layoutParams as RecyclerView.LayoutParams
        val currentIndex = params.viewAdapterPosition
        val currentView = findViewByPosition(currentIndex)

        if (currentIndex < itemCount - 1 || currentView == null) {
            return super.layoutDecoratedWithMargins(child, left, top, right, bottom)
        }

        val type = getItemViewType(currentView)
        val parentBottom = height - paddingBottom

        if (!expandTypes.contains(type) || bottom >= parentBottom) {
            return super.layoutDecoratedWithMargins(child, left, top, right, bottom)
        }

        val offset = (parentBottom - bottom) / 2
        super.layoutDecoratedWithMargins(child, left, top + offset, right, bottom + offset)
    }
}
