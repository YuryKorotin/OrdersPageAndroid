package com.yurykorotin.kworkrequests.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yurykorotin.kworkrequests.ItemActionsProcessor
import com.yurykorotin.kworkrequests.R
import com.yurykorotin.kworkrequests.databinding.OrderItemBinding
import com.yurykorotin.kworkrequests.ui.models.Order
import com.yurykorotin.kworkrequests.ui.models.OrderStatus

class OrdersAdapter(var orders: MutableList<Order>, val itemActionsProcessor: ItemActionsProcessor)
    : RecyclerView.Adapter<OrdersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = OrderItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return orders.size
    }

    fun resetOrders(orders: List<Order>) {
        val oldSize = itemCount
        notifyItemRangeRemoved(0, oldSize )
        this.orders.clear()

        this.orders.addAll(orders)
        notifyItemRangeInserted(0, orders.size)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = orders[position]

        holder.orderItemBinding.order = item
        holder.orderItemBinding.statusTextView.let {
            it.text = item.status.title(holder.itemView.resources)
            if(item.status is OrderStatus.InProcess) {
                it.background = it.resources.getDrawable(R.drawable.status_back, it.resources.newTheme())
                it.setTextColor(it.resources.getColor(R.color.colorFrame))
            } else {
                it.background = it.resources.getDrawable(R.drawable.status_back_inactive, it.resources.newTheme())
                it.setTextColor(it.resources.getColor(R.color.colorSecond))
            }
        }
        holder.orderItemBinding.dateLabel.text = item.dateLabel(holder.itemView.resources)
        holder.itemView.setOnClickListener{
            itemActionsProcessor.onOrderRequest(item)
            notifyDataSetChanged()
        }

        Glide
            .with(holder.itemView.context)
            .load(item.user.avatar)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.orderItemBinding.avatar)
    }

    class ViewHolder(val orderItemBinding: OrderItemBinding):
        RecyclerView.ViewHolder(orderItemBinding.root)
}