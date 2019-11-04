package com.example.meli.login.presenter

import androidx.appcompat.app.AppCompatActivity
import com.example.meli.core.model.LoginModel
import com.example.meli.login.contract.LoginContract
import com.example.meli.login.router.LoginRouter

class LoginPresenter(var mView: LoginContract.View?) : LoginContract.Presenter {

    private var mRouter: LoginContract.Router? = LoginRouter(mView as? AppCompatActivity)
    private var mLoginModel: LoginModel = LoginModel()

    override fun onEmailFilled(email: String) {
        mLoginModel.email = email
        if (mLoginModel.isValidEmail()) {
            mView?.hideEmailFilledError()
        } else {
            mView?.showEmailFilledError()
        }
    }

    override fun onPasswordFilled(password: String) {
        mLoginModel.password = password
        if (mLoginModel.isValidPassword()) {
            mView?.hidePasswordFilledError()
        } else {
            mView?.showPasswordFilledError()
        }
    }

    override fun onEnterButtonClicked(email: String, password: String) {
        mLoginModel.apply {
            this.email = email
            this.password = password
        }
        if (!mLoginModel.isValidEmail()) {
            mView?.showEmailFilledError()
            return
        }
        if (!mLoginModel.isValidPassword()) {
            mView?.showPasswordFilledError()
            return
        }
        mRouter?.goToSearchScreen()
    }

    override fun unregister() {
        mRouter?.unregister()
        mRouter = null
        mView = null
    }
}