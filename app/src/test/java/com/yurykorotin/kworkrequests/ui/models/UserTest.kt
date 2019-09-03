package com.yurykorotin.kworkrequests.ui.models

import android.content.res.Resources
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.yurykorotin.kworkrequests.R
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.Silent::class)
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

    @Test
    fun testToStringOutputsRole() {
        val user = User()

        val testTitle = "I am"

        val resources = mock<Resources> {
            on { getString(any())} doReturn testTitle
            on { getString(any(), any())} doReturn testTitle
        }

        assertTrue(user.getTitle(resources).contains(testTitle))
    }
}