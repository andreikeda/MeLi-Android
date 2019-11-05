package com.example.meli.login

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.meli.login.view.LoginActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginTest {

    @get:Rule
    var activityRule: ActivityTestRule<LoginActivity>
            = ActivityTestRule(LoginActivity::class.java)

    private lateinit var mRobot: LoginRobot

    @Before
    fun setUp() {
        mRobot = LoginRobot(activityRule)
    }

    @Test
    fun testLoginScreen_FillEmailWithInvalidData_CheckTextErrorEmail() {
        mRobot
            .login {
                start()
                fillEmail(LoginHelper.EMAIL_INVALID_EXTRA_DOTS)
                clickEnter()
                checkTextErrorEmail()
                stop()
            }
    }

    @Test
    fun testLoginScreen_FillEmailWithValidData_FillPasswordWithInvalidData_CheckTextErrorPassword() {
        mRobot
            .login {
                start()
                fillEmail(LoginHelper.EMAIL_VALID_NO_SUBDOMAIN)
                fillPassword(LoginHelper.PASSWORD_INVALID_MAX_LENGHT)
                clickEnter()
                checkTextErrorPassword()
                stop()
            }
    }
}