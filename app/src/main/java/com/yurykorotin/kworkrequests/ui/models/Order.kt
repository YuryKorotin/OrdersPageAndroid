package com.yurykorotin.kworkrequests.ui.models

import android.content.res.Resources
import com.yurykorotin.kworkrequests.utils.formatted
import java.util.*

data class Order(
    var id: Long = 0L,
    var user: User = User(),
    var name: String = "",
    var status: OrderStatus = OrderStatus.InProcess,
    var date: Date = Date(),
    //TODO: Add price formatter with currency
    var price: String = "") {
    fun dateLabel(resources: Resources): String {
        return date.formatted(resources)
    }
}