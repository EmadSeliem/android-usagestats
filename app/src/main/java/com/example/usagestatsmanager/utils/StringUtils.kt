package com.example.usagestatsmanager.utils

import java.text.SimpleDateFormat
import java.util.*


class StringUtils {
    companion object {
        fun formatTime(timeMillSecond: Long): String {
            val date = Date(timeMillSecond)
            val formatter = SimpleDateFormat("HH:mm:ss")
            formatter.timeZone = TimeZone.getTimeZone("UTC")
            return "Total Time Usage - ${formatter.format(date)}"

        }
    }
}