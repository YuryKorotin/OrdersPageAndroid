package com.yurykorotin.kworkrequests.ui.models

import org.junit.Assert.*
import org.junit.Test

class UserRoleTest {
    @Test
    fun testRoleName() {
        val role = UserRole.Customer

        assertNotNull(role.title())
    }
}