package com.yurykorotin.kworkrequests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yurykorotin.kworkrequests.adapters.FiltersAdapter
import com.yurykorotin.kworkrequests.adapters.OrdersAdapter
import com.yurykorotin.kworkrequests.ui.models.FilterItem
import com.yurykorotin.kworkrequests.ui.models.Order
import com.yurykorotin.kworkrequests.utils.Fixtures
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.net.Uri

class MainActivity : AppCompatActivity(), ItemActionsProcessor {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = getString(R.string.title)

        setupFilters()
        setupOrders()
    }

    fun setupFilters() {
        val layoutManager = LinearLayoutManager(applicationContext)
        layoutManager.orientation = RecyclerView.HORIZONTAL

        filterRecyclerView.layoutManager = layoutManager
        filterRecyclerView.adapter = FiltersAdapter(Fixtures.buildFilterItems(), this)
    }

    fun setupOrders() {
        val layoutManager = LinearLayoutManager(applicationContext)
        layoutManager.orientation = RecyclerView.VERTICAL

        ordersRecyclerView.layoutManager = layoutManager
        ordersRecyclerView.adapter = OrdersAdapter(Fixtures.buildOrders(), this)
    }

    override fun onOrderRequest(order: Order) {
        val kworkUrl = "https://kwork.ru"
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(kworkUrl))
        startActivity(browserIntent)
    }

    override fun onFilterChosen(filterItem: FilterItem) {

    }
}
