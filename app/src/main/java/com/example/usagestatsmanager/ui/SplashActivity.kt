package com.example.usagestatsmanager.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.usagestatsmanager.R
import com.example.usagestatsmanager.utils.NavigationHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private val activityScope = CoroutineScope(Dispatchers.Main)
    @Inject
     lateinit var navigationHelper: NavigationHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        activityScope.launch {
            delay(2000)
            navigationHelper.navigateToMainScreen()
        }
    }
}