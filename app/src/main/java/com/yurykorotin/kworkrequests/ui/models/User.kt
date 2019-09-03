package com.yurykorotin.kworkrequests.ui.models

data class User(var name: String = "", var role: UserRole = UserRole.Customer) {
    fun isCustomer(): Boolean {
        return role is UserRole.Customer
    }

    fun isSeller(): Boolean {
        return role is UserRole.Seller
    }
}