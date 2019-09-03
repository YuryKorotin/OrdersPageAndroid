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
import android.view.animation.OvershootInterpolator
import android.widget.ArrayAdapter
import com.yurykorotin.kworkrequests.ui.models.OrderStatus
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator


class MainActivity : AppCompatActivity(), ItemActionsProcessor {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupToolbar()
        setupFilters()
        setupOrders()
    }

    private fun setupToolbar() {
        title = getString(R.string.title)

        setSupportActionBar(ordersToolbar)

        val users = Fixtures.buildUsers().map { it.getTitle(resources) }

        val adapter = ArrayAdapter(
            this,
            R.layout.filter_spinner_item,
            users.toTypedArray()
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        if (userTypeSpinner != null) {
            userTypeSpinner.adapter = adapter
        }
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
        ordersRecyclerView.adapter = OrdersAdapter(Fixtures.buildOrders().toMutableList(), this)
        ordersRecyclerView.itemAnimator = SlideInUpAnimator(OvershootInterpolator(0.1f))
    }

    override fun onOrderRequest(order: Order) {
        val kworkUrl = "https://kwork.ru"
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(kworkUrl))
        startActivity(browserIntent)
    }

    override fun onFilterChosen(filterItem: FilterItem) {
        when(filterItem.status) {
            is OrderStatus.InProcess -> {
                (ordersRecyclerView.adapter as OrdersAdapter).resetOrders(Fixtures.buildOrders())
            }
            is OrderStatus.AwaitingData-> {
                (ordersRecyclerView.adapter as OrdersAdapter).resetOrders(Fixtures.buildWaitingOrders())
            }
        }
    }
}
