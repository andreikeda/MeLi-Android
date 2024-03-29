package com.example.meli.core

import java.util.regex.Pattern

class TextValidator {
     private val EMAIL_PATTERN =
         Pattern.compile("[a-zA-Z0-9+._%\\-]{1,256}@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+")
    private val PASSWORD_MIN_LENGTH = 8
    private val PASSWORD_MAX_LENGTH = 12

    /**
     * Method to check if string is a valid email
     *
     * @param email - String to be compared to email pattern
     * @return <b>true</b> if string is a valid email and <b>false</b> otherwise
     */
     fun isValidEmail(email: String): Boolean {
         return EMAIL_PATTERN.matcher(email).matches()
     }

    /**
     * Method to check if string is a valid password
     *
     * @param password - String to be compared to password min and max length
     * @return <b>true</b> if string is a valid password and <b>false</b> otherwise
     */
    fun isValidPassword(password: String): Boolean {
        return password.length in PASSWORD_MIN_LENGTH..PASSWORD_MAX_LENGTH
    }
}