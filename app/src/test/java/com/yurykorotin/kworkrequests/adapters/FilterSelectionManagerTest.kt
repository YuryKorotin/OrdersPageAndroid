package com.yurykorotin.kworkrequests.adapters

import com.yurykorotin.kworkrequests.utils.Fixtures
import junit.framework.Assert.assertEquals
import org.junit.Test

class FilterSelectionManagerTest {

    @Test
    fun onSelectionFilter() {
        val testItems = Fixtures.buildFilterItems()

        val manager = FilterSelectionManager(testItems)
        manager.onSelectionFilter(testItems[1])

        assertEquals(1, testItems.count { it.active })
    }

}