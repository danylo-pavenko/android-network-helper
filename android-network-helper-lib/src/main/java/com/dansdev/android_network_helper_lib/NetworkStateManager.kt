package com.dansdev.android_network_helper_lib

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.core.content.getSystemService
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class NetworkStateManager: INetworkStateManager {

    @SuppressLint("MissingPermission")
    override fun isHasConnection(context: Context): Boolean {
        val connManager = context.getSystemService<ConnectivityManager>()
        val networkCapabilities = connManager?.getNetworkCapabilities(connManager.activeNetwork)
        if (networkCapabilities == null) {
            return false
        } else {
            return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                    networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED) &&
                    networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_SUSPENDED)
        }
    }

    override fun isInternetAvailable(connectionTimeout: Int): Boolean {
        val urlConnection = URL("https://clients3.google.com/generate_204").openConnection() as HttpsURLConnection
        return try {
            urlConnection.setRequestProperty("User-Agent", "Android")
            urlConnection.setRequestProperty("Connection", "close")
            urlConnection.connectTimeout = connectionTimeout
            urlConnection.connect()
            urlConnection.responseCode == 204
        } catch (e: Exception) {
            false
        }
    }
}
