package com.yurykorotin.kworkrequests.ui.models

import android.app.Application
import android.content.res.Resources
import com.yurykorotin.kworkrequests.R

sealed class UserRole {
    abstract fun title(resources: Resources): String

    object Customer : UserRole() {
        override fun title(resources: Resources): String {
            return resources.getString(R.string.customer)
        }
    }

    object Seller : UserRole() {
        override fun title(resources: Resources): String {
            return resources.getString(R.string.seller)
        }
    }
}