package com.example.meli.login

import android.content.Context
import android.content.Intent
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.example.meli.BaseTestRobot
import com.example.meli.R
import com.example.meli.login.view.LoginActivity

class LoginRobot(var activityTestRule: ActivityTestRule<LoginActivity>?) : BaseTestRobot() {
    private val BUTTON_ENTER = R.id.button_enter
    private val INPUT_EMAIL = R.id.input_email
    private val INPUT_PASSWORD = R.id.input_password
    private val INPUT_LAYOUT_EMAIL = R.id.input_layout_email
    private val INPUT_LAYOUT_PASSWORD = R.id.input_layout_password
    private val TEXT_EMAIL_ERROR_ID = R.string.error_invalid_email
    private val TEXT_PASSWORD_ERROR_ID = R.string.error_invalid_password

    private val context: Context
        get() = InstrumentationRegistry.getInstrumentation().targetContext

    fun start() {
        activityTestRule?.launchActivity(Intent())
    }

    fun stop() {
        activityTestRule?.finishActivity()
        activityTestRule = null
    }

    fun login(func: LoginRobot.() -> Unit) = LoginRobot(activityTestRule)
        .apply { func() }

    fun checkTextErrorEmail() = matchTextInputLayoutError(INPUT_LAYOUT_EMAIL, context.getString(TEXT_EMAIL_ERROR_ID))
    fun checkTextErrorPassword() = matchTextInputLayoutError(INPUT_LAYOUT_PASSWORD, context.getString(TEXT_PASSWORD_ERROR_ID))
    fun clickEnter() = clickButton(BUTTON_ENTER)
    fun fillEmail(email: String) = fillEditText(INPUT_EMAIL, email)
    fun fillPassword(password: String) = fillEditText(INPUT_PASSWORD, password)
}
