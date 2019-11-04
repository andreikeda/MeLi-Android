package com.example.meli

import com.example.meli.core.model.SearchResultModel

object TestHelper {

    val QUERY = "motorola g6"
    val data: SearchResultModel = SearchResultModel().apply {

    }

    const val EMAIL_VALID_NO_SUBDOMAIN = "email_no_subdomain@mock.com"
    const val EMAIL_VALID_WITH_SUBDOMAIN = "email_with_subdomain@mock.com.br"
    const val EMAIL_INVALID_NO_DOMAIN = "email_no_domain@mock"
    const val EMAIL_INVALID_EXTRA_DOTS = "email_extra_dots@mock..com"
    const val EMAIL_INVALID_NO_USERNAME = "@no_username.com"
    const val PASSWORD_VALID = "abcd@1234"
    const val PASSWORD_VALID_LIMIT_MIN_LENGTH = "abcd@123"
    const val PASSWORD_VALID_LIMIT_MAX_LENGTH = "abcd@1234|09"
    const val PASSWORD_INVALID_MIN_LENGHT = "abcd@"
    const val PASSWORD_INVALID_MAX_LENGHT = "abcd@1234|mu9801"
}