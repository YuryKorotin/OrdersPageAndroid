package com.yurykorotin.kworkrequests.utils

import com.yurykorotin.kworkrequests.ui.models.FilterItem
import com.yurykorotin.kworkrequests.ui.models.OrderStatus

object Fixtures {
    fun buildFilterItems(): List<FilterItem> {
        val result = mutableListOf<FilterItem>()
        result.add(FilterItem(1L, OrderStatus.InProcess, true))
        result.add(FilterItem(2L, OrderStatus.AwaitingData, false))

        return result.toList()
    }
}