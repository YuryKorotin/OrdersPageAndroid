package com.yurykorotin.kworkrequests.ui.models

import org.junit.Assert.*
import org.junit.Test

class UserTest {
    @Test
    fun testUserRoleIsCustomerByDefault() {
        val user = User()

        assertTrue(user.isCustomer())
    }

    @Test
    fun testChangeUserRole() {
        val user = User()

        user.role = UserRole.Seller

        assertTrue(user.isSeller())
    }
}