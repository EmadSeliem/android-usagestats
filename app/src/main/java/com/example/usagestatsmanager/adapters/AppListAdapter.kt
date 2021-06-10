package com.example.usagestatsmanager.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.usagestatsmanager.R
import com.example.usagestatsmanager.data.ApplicationData
import com.example.usagestatsmanager.databinding.AppItemBinding
import com.example.usagestatsmanager.utils.StringUtils

class AppListAdapter() :
    RecyclerView.Adapter<AppListAdapter.ViewHolder>() {

    lateinit var employeeList: ArrayList<ApplicationData>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: AppItemBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.app_item,
            parent, false
        )
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return employeeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(employeeList[position])
    }

    inner class ViewHolder(private val binding: AppItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(applicationData: ApplicationData) {
            binding.appData = applicationData
            binding.stringUtils = StringUtils.Companion
            binding.executePendingBindings()
        }

    }


}