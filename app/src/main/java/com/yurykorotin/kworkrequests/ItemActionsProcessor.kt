package com.yurykorotin.kworkrequests

import com.yurykorotin.kworkrequests.ui.models.FilterItem
import com.yurykorotin.kworkrequests.ui.models.Order

interface ItemActionsProcessor {
    fun onOrderRequest(order: Order)
    fun onFilterChosen(filterItem: FilterItem)
}