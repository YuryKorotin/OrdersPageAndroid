package com.yurykorotin.kworkrequests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yurykorotin.kworkrequests.adapters.FiltersAdapter
import com.yurykorotin.kworkrequests.adapters.OrdersAdapter
import com.yurykorotin.kworkrequests.ui.models.Order
import com.yurykorotin.kworkrequests.utils.Fixtures
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
        filterRecyclerView.adapter = FiltersAdapter(Fixtures.buildFilterItems())
    }

    fun setupOrders() {
        val layoutManager = LinearLayoutManager(applicationContext)
        layoutManager.orientation = RecyclerView.VERTICAL

        ordersRecyclerView.layoutManager = layoutManager
        ordersRecyclerView.adapter = OrdersAdapter(Fixtures.buildOrders())
    }

    fun onOrderRequest(order: Order) {

    }
}
