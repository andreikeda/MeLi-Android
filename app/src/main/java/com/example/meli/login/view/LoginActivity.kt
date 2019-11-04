package com.example.meli.login.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.meli.R
import com.example.meli.login.contract.LoginContract
import com.example.meli.login.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private var mPresenter: LoginContract.Presenter? = null
    private val mEmailWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) = Unit

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            mPresenter?.onEmailFilled(input_email.text.toString())
        }
    }
    private val mPasswordWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) = Unit

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            mPresenter?.onPasswordFilled(input_password.text.toString())
        }
    }

    override fun hideEmailFilledError() {
        input_layout_email.error = null
    }

    override fun hidePasswordFilledError() {
        input_layout_password.error = null
    }

    override fun showEmailFilledError() {
        input_layout_email.error = getString(R.string.error_invalid_email)
    }

    override fun showPasswordFilledError() {
        input_layout_password.error = getString(R.string.error_invalid_password)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        input_email.addTextChangedListener(mEmailWatcher)
        input_password.addTextChangedListener(mPasswordWatcher)
        button_enter.setOnClickListener {
            mPresenter?.onEnterButtonClicked(input_email.text.toString(), input_password.text.toString())
        }

        mPresenter = LoginPresenter(this)
    }

    override fun onDestroy() {
        input_email.removeTextChangedListener(mEmailWatcher)
        input_password.removeTextChangedListener(mPasswordWatcher)

        mPresenter?.unregister()
        mPresenter = null

        super.onDestroy()
    }
}