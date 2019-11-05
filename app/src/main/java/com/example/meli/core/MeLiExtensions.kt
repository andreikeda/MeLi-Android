package com.example.meli.core

import android.content.Context
import android.net.ConnectivityManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.meli.R
import com.google.android.material.snackbar.Snackbar

/**
 * Method to close soft keyboard
 *
 * @param view - If there is a view with focus, pass the view as parameter or <b>null</b> if not
 */
fun Context.closeKeyboard(view: View?) {
    view?.let {
        (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(it.windowToken, 0)
    }
}

/**
 * Method to check if internet connection is available
 *
 * @return <b>true</b> if internet connection is available or <b>false</b> otherwise
 */
fun Context.isInternetConnectionAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}

/**
 * Method to show a {@see SnackBar} when internet connection is unavailable
 *
 * @param rootView - Parent view
 */
fun Context.showInternetConnectionErrorSnackBar(rootView: View) {
    Snackbar
        .make(rootView, getString(R.string.error_no_connection_message), Snackbar.LENGTH_INDEFINITE)
        .setAction(R.string.button_refresh) {
            if (!isInternetConnectionAvailable()) {
                showInternetConnectionErrorSnackBar(rootView)
            }
        }.show()
}

/**
 * Method to split a {@see HashMap} into a small {@see HashMap}
 *
 * @param interval - how many items (maximum) the new {@see HashMap} must have
 * @param initial - first position for cloning {@see HashMap} to new one
 */
fun HashMap<String, String>.splitInto(interval: Int, initial: Int): HashMap<String, String> {
    val splittedHashMap = hashMapOf<String, String>()
    var count = 0
    var reachInitial = false
    forEach { (key, value) ->
        if (count == initial) {
            reachInitial = true
        }
        count++
        if (reachInitial && (count <= (interval + initial))) {
            splittedHashMap[key] = value
        } else if (count > (interval + initial)) {
            return@forEach
        }
    }
    return splittedHashMap
}