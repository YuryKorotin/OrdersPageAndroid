package com.yurykorotin.kworkrequests.ui.models

import android.content.res.Resources
import com.yurykorotin.kworkrequests.R

data class User(var name: String = "", var role: UserRole = UserRole.Customer) {
    fun isCustomer(): Boolean {
        return role is UserRole.Customer
    }

    fun isSeller(): Boolean {
        return role is UserRole.Seller
    }

    fun getTitle(resources: Resources): String {
        val roleTitle = role.title(resources)
        return resources.getString(R.string.user_title, roleTitle)
    }
}