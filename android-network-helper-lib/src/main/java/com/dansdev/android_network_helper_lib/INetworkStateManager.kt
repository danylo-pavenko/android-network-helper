package com.dansdev.android_network_helper_lib

import android.content.Context

interface INetworkStateManager {

    fun isHasConnection(context: Context): Boolean

    fun isInternetAvailable(connectionTimeout: Int = 1000): Boolean
}
