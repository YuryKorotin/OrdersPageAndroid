package com.yurykorotin.kworkrequests.ui.models

import android.content.res.Resources
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.yurykorotin.kworkrequests.R
import com.yurykorotin.kworkrequests.utils.isNotCurrentYear
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner.Silent::class)
class OrderTest {
    companion object {
        val todayText = "today"
        val yesterdayText = "yesterday"
    }
    var resources: Resources? = null

    @Before
    fun setUp() {
        resources = mock<Resources> {
            on { getString(R.string.yesterday)} doReturn yesterdayText
            on { getString(R.string.today)} doReturn todayText
        }
    }

    @Test
    fun testOnlyHoursDateWhenPeriodIsMin() {
        val order = Order()
        order.date = Date()

        assertTrue(order.dateLabel(resources!!).contains(":"))
    }

    @Test
    fun testTodayWhenMoreThanMinPeriod() {
        val calendar = Calendar.getInstance()
        var currentHour = calendar.get(Calendar.HOUR)

        calendar.set(Calendar.HOUR, currentHour - 6)

        val order = Order()
        order.date = calendar.time

        assertTrue(order.dateLabel(resources!!).contains(todayText))
    }

    @Test
    fun testYesterdayFormatting() {
        val calendar = Calendar.getInstance()
        var currentHour = calendar.get(Calendar.HOUR)

        calendar.set(Calendar.HOUR, currentHour - 24)

        val order = Order()
        order.date = calendar.time

        assertTrue(order.dateLabel(resources!!).contains(yesterdayText))
    }

    @Test
    fun testNotCurrentYearFormatting() {
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val yearOfOrder = currentYear - 2

        calendar.set(Calendar.YEAR, yearOfOrder)

        val order = Order()
        order.date = calendar.time

        val formattedYear = (yearOfOrder % 100).toString()

        assertTrue(order.dateLabel(resources!!).contains(formattedYear))
    }

    @Test
    fun testCurrentYearFormatting() {
        val calendar = Calendar.getInstance()
        val currentDay = calendar.get(Calendar.DAY_OF_YEAR)
        val dayOfOrder = currentDay - 3

        calendar.set(Calendar.DAY_OF_YEAR, dayOfOrder)

        val order = Order()
        order.date = calendar.time

        val currentYear = calendar.get(Calendar.YEAR)
        val yearOfOrder = currentYear - 2
        val formattedYear = (yearOfOrder % 100).toString()

        assertFalse(order.dateLabel(resources!!).contains(formattedYear))
    }
}