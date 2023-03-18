package com.dansdev.android_network_helper_lib

import android.content.Context

private val networkStateManager: INetworkStateManager = NetworkStateManager()

fun Context.isHasConnection(): Boolean {
    return networkStateManager.isHasConnection(this)
}

fun Context.isNetworkAvailable(): Boolean {
    return networkStateManager.isInternetAvailable()
}
