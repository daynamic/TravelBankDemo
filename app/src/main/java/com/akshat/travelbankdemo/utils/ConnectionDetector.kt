package com.akshat.travelbankdemo.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import androidx.annotation.RequiresApi


class ConnectionDetector {
    @RequiresApi(Build.VERSION_CODES.M)
    fun isConnectingToInternet(context: Context): Boolean {
        var result = false
        val connectivity = context.getSystemService(
            Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivity != null) {
            connectivity.let {
                it.getNetworkCapabilities(connectivity.activeNetwork)?.apply {
                    result = when {
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        else -> false
                    }
                }
            }
        }
        return result
    }
}