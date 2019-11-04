package com.example.meli.login.router

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.meli.login.contract.LoginContract
import com.example.meli.search.view.SearchActivity

class LoginRouter(var activity: AppCompatActivity?): LoginContract.Router {
    override fun goToSearchScreen() {
        activity?.startActivity(
            Intent(activity, SearchActivity::class.java)
        )
    }

    override fun unregister() {
        activity = null
    }
}