package com.example.meli.core.model

import com.example.meli.core.TextValidator

class LoginModel {
    private val validator = TextValidator()

    var email: String = ""
    var password: String = ""

    fun isValidEmail() = validator.isValidEmail(email)

    fun isValidPassword() = validator.isValidPassword(password)
}