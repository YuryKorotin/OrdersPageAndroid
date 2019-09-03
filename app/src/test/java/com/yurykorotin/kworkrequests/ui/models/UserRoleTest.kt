package com.yurykorotin.kworkrequests.ui.models

import android.content.res.Resources
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserRoleTest {
    @Test
    fun testRoleName() {
        val role = UserRole.Customer

        val testTitle = "test"

        val resources = mock<Resources> {
            on { getString(any()) } doReturn testTitle
        }

        assertNotNull(role.title(resources))
    }
}