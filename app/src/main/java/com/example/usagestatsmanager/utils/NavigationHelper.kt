package com.example.usagestatsmanager.utils

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import com.example.usagestatsmanager.ui.MainActivity

class NavigationHelper(private val context: Context) {

    fun navigateToMainScreen() {
        val intent = Intent(context, MainActivity::class.java)
        intent.addFlags(FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}