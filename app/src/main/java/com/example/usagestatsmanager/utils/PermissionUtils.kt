package com.example.usagestatsmanager.utils

import android.app.AppOpsManager
import android.app.AppOpsManager.MODE_ALLOWED
import android.app.AppOpsManager.OPSTR_GET_USAGE_STATS
import android.content.Context
import android.content.pm.PackageManager
import android.os.Process


class PermissionUtils(private val context: Context) {
    fun isPermissionGranted(): Boolean {
        val appOps: AppOpsManager =
            context.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
        val mode = appOps.checkOpNoThrow(
            OPSTR_GET_USAGE_STATS,
            Process.myUid(), context.packageName
        )
        return if (mode == AppOpsManager.MODE_DEFAULT) {
            (context.checkCallingOrSelfPermission(android.Manifest.permission.PACKAGE_USAGE_STATS) == PackageManager.PERMISSION_GRANTED);
        } else {
            (mode == MODE_ALLOWED);
        }
    }
}
