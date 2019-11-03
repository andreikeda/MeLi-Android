package com.example.meli.core

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.meli.R
import com.google.android.material.snackbar.Snackbar

fun Context.closeKeyboard(view: View?) {
    view?.let {
        (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(it.windowToken, 0)
    }
}

fun Context.isInternetConnectionAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}

fun Context.showInternetConnectionErrorSnackBar(rootView: View) {
    Snackbar
        .make(rootView, getString(R.string.error_no_connection_message), Snackbar.LENGTH_INDEFINITE)
        .setAction(getString(R.string.button_go_settings)) {
            startActivity(
                Intent(Intent.ACTION_MAIN).apply {
                    setClassName("com.android.phone", "com.android.phone.NetworkSetting")
                }
            )
        }.show()
}
