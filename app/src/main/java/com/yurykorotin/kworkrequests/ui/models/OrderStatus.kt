package com.yurykorotin.kworkrequests.ui.models

import android.content.res.Resources
import com.yurykorotin.kworkrequests.R

sealed class OrderStatus {
    abstract fun title(resources: Resources): String

    object InProcess: OrderStatus() {
        override fun title(resources: Resources): String {
            return resources.getString(R.string.in_process)
        }
    }

    object AwaitingData : OrderStatus() {
        override fun title(resources: Resources): String {
            return resources.getString(R.string.awaiting_data)
        }
    }
}