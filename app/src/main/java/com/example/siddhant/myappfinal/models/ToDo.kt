package com.example.siddhant.myappfinal.models

import android.support.v7.widget.DialogTitle

/**
 * Created by siddhant on 04-07-2017.
 */
data  class ToDo(
        val userId: Int,
        val id: Int,
        val title: String,
        val completed : Boolean
)