package com.example.siddhant.myappfinal.models

import android.provider.ContactsContract
import java.net.URL

/**
 * Created by siddhant on 03-07-2017.
 */
data class User(
        val id: Int,
        val username: String,
        val name: String,
        val email: String,
        val phone: String
)