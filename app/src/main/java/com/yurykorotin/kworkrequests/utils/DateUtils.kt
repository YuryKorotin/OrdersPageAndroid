package com.yurykorotin.kworkrequests.utils

import android.content.res.Resources
import com.yurykorotin.kworkrequests.R
import com.yurykorotin.kworkrequests.utils.DateConsts.DAYS_AGO_IN_MILLISECONDS
import com.yurykorotin.kworkrequests.utils.DateConsts.MILLISECONDS_IN_A_HOUR
import java.text.SimpleDateFormat
import java.util.*

object DateConsts{
    const val MILLISECONDS_IN_A_HOUR = 3600000
    private const val MILLISECONDS_IN_A_DAY = 86400000
    const val DAYS_AGO_IN_MILLISECONDS = MILLISECONDS_IN_A_DAY * 2

    val NOT_CURRENT_YEAR_FORMATTER = SimpleDateFormat("dd.MM.yy", Locale.US)
    val DAYS_AGO_FORMATTER = SimpleDateFormat("dd.MM", Locale.US)
    val TODAY_FORMATTER = SimpleDateFormat("HH:MM", Locale.US)
}

fun Date.formatted(resources: Resources): String {
    if (isNotCurrentYear()) {
        return DateConsts.NOT_CURRENT_YEAR_FORMATTER.format(this)
    }
    if (isMoreThanDaysAgo()) {
        return DateConsts.DAYS_AGO_FORMATTER.format(this)
    }

    if (isYesterday()) {
        return resources.getString(R.string.yesterday)
    }

    if (isToday()) {
        return resources.getString(R.string.today)
    }

    return DateConsts.TODAY_FORMATTER.format(this)
}

fun Date.isToday(): Boolean {
    val diff = Date().time - time

    return diff > MILLISECONDS_IN_A_HOUR * 4 && diff < MILLISECONDS_IN_A_HOUR * 24
}

fun Date.isYesterday(): Boolean {
    val calendar = Calendar.getInstance()
    calendar.time = this
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val month = calendar.get(Calendar.MONTH)

    calendar.time = Date()
    val currentDay = calendar.get(Calendar.DAY_OF_MONTH)
    val currentMonth = calendar.get(Calendar.MONTH)

    return month == currentMonth && currentDay - day == 1
}

fun Date.isMoreThanDaysAgo(): Boolean {
    val diff = Date().time - time

    return diff > DAYS_AGO_IN_MILLISECONDS
}

fun Date.isNotCurrentYear(): Boolean {
    val calendar = Calendar.getInstance()
    calendar.time = this

    val year = calendar.get(Calendar.YEAR)

    calendar.time = Date()
    val currentYear = calendar.get(Calendar.YEAR)

    return year != currentYear
}