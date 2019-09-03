package com.yurykorotin.kworkrequests.ui.models

sealed class UserRole {
    class Customer: UserRole()
    class Seller: UserRole()
}