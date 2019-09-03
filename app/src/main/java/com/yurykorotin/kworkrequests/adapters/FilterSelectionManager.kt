package com.yurykorotin.kworkrequests.adapters

import com.yurykorotin.kworkrequests.ui.models.FilterItem

class FilterSelectionManager(val filters: List<FilterItem>) {
    fun onSelectionFilter(item: FilterItem) {
        filters.forEach{
            it.active = it.id == item.id
        }
    }
}