package com.example.androidportfolio.util

import android.view.View
import android.view.ViewGroup


fun View.setMargins(margin: Int) {
    setMargins(margin, margin, margin, margin)
}

fun View.setMargins(left: Int, top: Int, right: Int, bottom: Int) {
    layoutParams = (layoutParams as ViewGroup.MarginLayoutParams).apply {
        setMargins(left, top, right, bottom)
    }
}
