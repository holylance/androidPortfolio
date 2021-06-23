package com.example.androidportfolio.util

import android.content.res.Resources
import androidx.annotation.StringRes

fun Resources.dpToPx(dp: Int): Float {
    return dp * displayMetrics.density
}

fun Resources.getString(@StringRes id: Int?): String? {
    return id?.let { getString(it) }
}
