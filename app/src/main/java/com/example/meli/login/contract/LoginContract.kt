package com.example.meli.login.contract

interface LoginContract {
    interface Presenter {
        fun onEmailFilled(email: String)
        fun onPasswordFilled(password: String)
        fun onEnterButtonClicked(email: String, password: String)
        fun unregister()
    }

    interface Router {
        fun goToSearchScreen()
        fun unregister()
    }

    interface View {
        fun hideEmailFilledError()
        fun hidePasswordFilledError()
        fun showEmailFilledError()
        fun showPasswordFilledError()
    }
}