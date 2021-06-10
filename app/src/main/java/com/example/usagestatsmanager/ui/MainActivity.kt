package com.example.usagestatsmanager.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.usagestatsmanager.R
import com.example.usagestatsmanager.utils.PermissionUtils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import android.provider.Settings;
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.usagestatsmanager.adapters.AppListAdapter
import com.example.usagestatsmanager.data.ApplicationData
import com.example.usagestatsmanager.databinding.MainActivityBinding
import com.example.usagestatsmanager.viewmodels.MainActivityViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var permissionUtils: PermissionUtils
    @Inject
    lateinit var applicationListAdapter: AppListAdapter

    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    private lateinit var dataBinding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        mainActivityViewModel.appDataList.observe(this, Observer {
            applicationListAdapter.employeeList = it as ArrayList<ApplicationData>
            dataBinding.employeeList.adapter = applicationListAdapter

        })

    }

    override fun onResume() {
        super.onResume()
        if (!permissionUtils.isPermissionGranted())
            startActivity(Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS))
        else
            mainActivityViewModel.getAllOpenedApps()
    }
}