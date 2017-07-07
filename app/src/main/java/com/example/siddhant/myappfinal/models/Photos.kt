package com.example.siddhant.myappfinal.models

import android.net.Uri
import retrofit2.http.Url

/**
 * Created by siddhant on 05-07-2017.
 */
data class Photos(
        val albumId: Int,
        val id : Int,
        val title: String,
        val url: Url,
        val thumbnailUrl: Url
)