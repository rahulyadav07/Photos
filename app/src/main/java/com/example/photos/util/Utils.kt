package com.example.photos.util

import android.content.Context
import android.net.ConnectivityManager


class Utils {
    companion object {

        fun isInternetAvailable(context: Context): Boolean {
            (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
                return  this.activeNetworkInfo?.isConnected ?: false
            }
        }
    }
}