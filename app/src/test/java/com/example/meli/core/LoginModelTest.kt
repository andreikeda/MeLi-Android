package com.example.meli.core

import com.example.meli.TestHelper
import com.example.meli.core.model.LoginModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class LoginModelTest {

    private lateinit var mLoginModel: LoginModel

    @Before
    fun setUp() {
        mLoginModel = LoginModel()
    }

    @Test
    fun testLoginModel_EmailNoSubdomain_ReturnsTrue() {
        mLoginModel.email = TestHelper.EMAIL_VALID_NO_SUBDOMAIN
        Assert.assertTrue(mLoginModel.isValidEmail())
    }

    @Test
    fun testLoginModel_EmailWithSubdomain_ReturnsTrue() {
        mLoginModel.email = TestHelper.EMAIL_VALID_WITH_SUBDOMAIN
        Assert.assertTrue(mLoginModel.isValidEmail())
    }

    @Test
    fun testLoginModel_EmailNoDomain_ReturnsFalse() {
        mLoginModel.email = TestHelper.EMAIL_INVALID_NO_DOMAIN
        Assert.assertFalse(mLoginModel.isValidEmail())
    }

    @Test
    fun testLoginModel_EmailExtraDots_ReturnsFalse() {
        mLoginModel.email = TestHelper.EMAIL_INVALID_EXTRA_DOTS
        Assert.assertFalse(mLoginModel.isValidEmail())
    }

    @Test
    fun testLoginModel_EmailNoUsername_ReturnsFalse() {
        mLoginModel.email = TestHelper.EMAIL_INVALID_NO_USERNAME
        Assert.assertFalse(mLoginModel.isValidEmail())
    }

    @Test
    fun testLoginModel_PasswordValid_ReturnsTrue() {
        mLoginModel.password = TestHelper.PASSWORD_VALID
        Assert.assertTrue(mLoginModel.isValidPassword())
    }

    @Test
    fun testLoginModel_PasswordValidLimitMinLength_ReturnsTrue() {
        mLoginModel.password = TestHelper.PASSWORD_VALID_LIMIT_MIN_LENGTH
        Assert.assertTrue(mLoginModel.isValidPassword())
    }

    @Test
    fun testLoginModel_PasswordValidLimitMaxLength_ReturnsTrue() {
        mLoginModel.password = TestHelper.PASSWORD_VALID_LIMIT_MAX_LENGTH
        Assert.assertTrue(mLoginModel.isValidPassword())
    }

    @Test
    fun testLoginModel_PasswordInvalidMinLength_ReturnsFalse() {
        mLoginModel.password = TestHelper.PASSWORD_INVALID_MIN_LENGHT
        Assert.assertFalse(mLoginModel.isValidPassword())
    }

    @Test
    fun testLoginModel_PasswordInvalidMaxLength_ReturnsFalse() {
        mLoginModel.password = TestHelper.PASSWORD_INVALID_MAX_LENGHT
        Assert.assertFalse(mLoginModel.isValidPassword())
    }
}