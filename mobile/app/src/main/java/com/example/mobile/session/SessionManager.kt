package com.example.mobile.session

import com.example.mobile.models.User

object SessionManager {
    var access_token: String? = null
    var refresh_token: String? = null
    var currentUser: User? = null
}
