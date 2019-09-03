package com.yurykorotin.kworkrequests.ui.models

data class FilterItem(
    val id: Long = 0L,
    var status: OrderStatus = OrderStatus.InProcess,
    var active: Boolean = false)