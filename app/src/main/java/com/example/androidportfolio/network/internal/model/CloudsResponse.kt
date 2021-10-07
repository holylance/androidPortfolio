package com.example.androidportfolio.network.internal.model

import com.example.androidportfolio.network.model.Clouds

internal data class CloudsResponse(
    val all: Int
) {
    internal fun toClouds() =
        Clouds(all)
}
