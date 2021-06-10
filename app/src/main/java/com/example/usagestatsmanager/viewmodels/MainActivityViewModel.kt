package com.example.usagestatsmanager.viewmodels

import android.app.usage.UsageStatsManager
import android.content.Context
import android.content.Context.USAGE_STATS_SERVICE
import android.content.pm.ApplicationInfo
import android.graphics.drawable.Drawable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usagestatsmanager.data.ApplicationData
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(@ApplicationContext val context: Context) :
    ViewModel() {
    val appDataList = MutableLiveData<List<ApplicationData>>()
    private val applicationList = ArrayList<ApplicationData>()

    private  fun loadStatistics() {
        val usm = context.getSystemService(USAGE_STATS_SERVICE) as UsageStatsManager
        val appList = usm.queryUsageStats(
            UsageStatsManager.INTERVAL_DAILY,
            System.currentTimeMillis() - 1000 * 3600 * 24,
            System.currentTimeMillis()
        )
        if (appList.isNotEmpty()) {
            for (application in appList) {
                if (application.totalTimeInForeground > 0) {
                    val ai: ApplicationInfo =
                        context.packageManager
                            .getApplicationInfo(application.packageName, 0)
                    val icon: Drawable = context.packageManager
                        .getApplicationIcon(ai)
                    val appName = context.packageManager
                        .getApplicationLabel(ai).toString()
                    val appData = ApplicationData(appName, application.totalTimeInForeground, icon)
                    applicationList.add(appData)
                    appDataList.postValue(applicationList)
                }
            }
        }
    }

    fun getAllOpenedApps() {
        viewModelScope.launch(Dispatchers.Default) {
            loadStatistics()
        }
    }

}