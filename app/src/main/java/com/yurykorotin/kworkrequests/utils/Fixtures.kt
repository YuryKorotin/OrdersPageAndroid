package com.yurykorotin.kworkrequests.utils

import com.yurykorotin.kworkrequests.ui.models.FilterItem
import com.yurykorotin.kworkrequests.ui.models.Order
import com.yurykorotin.kworkrequests.ui.models.OrderStatus
import com.yurykorotin.kworkrequests.ui.models.User
import java.util.*

object Fixtures {
    fun buildFilterItems(): List<FilterItem> {
        val result = mutableListOf<FilterItem>()
        result.add(FilterItem(1L, OrderStatus.InProcess, true))
        result.add(FilterItem(2L, OrderStatus.AwaitingData, false))

        return result.toList()
    }

    fun buildOrders(): List<Order> {
        val user = User("Tony Stark", "https://image.dhgate.com/0x0/f2/albu/g4/M01/CC/67/rBVaEVm3eneAU19mAAKIsNdQWYs177.jpg")
        val price = "155 000\u20BD"

        val result = mutableListOf<Order>()
        result.add(Order(1L, user, "Сборка Mark 42", OrderStatus.InProcess, Date(), price))
        result.add(Order(2L, user, "Покраска Mark 345", OrderStatus.InProcess, Date(), price))
        result.add(Order(3L, user, "Низвержение таноса", OrderStatus.InProcess, Date(), price))
        result.add(Order(4L, user, "Съемка с квадрокоптера всего процесса обучения", OrderStatus.InProcess, Date(), price))

        return result.toList()
    }
}