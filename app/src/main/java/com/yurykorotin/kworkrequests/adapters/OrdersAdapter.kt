package com.yurykorotin.kworkrequests.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yurykorotin.kworkrequests.databinding.FilterItemBinding
import com.yurykorotin.kworkrequests.ui.models.FilterItem

class FiltersAdapter(var filterItems: List<FilterItem>)
    : RecyclerView.Adapter<FiltersAdapter.ViewHolder>() {
    val filterSelectionManager: FilterSelectionManager = FilterSelectionManager(filterItems)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FilterItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return filterItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = filterItems[position]

        holder.filterItemBinding.filter = item
        holder.filterItemBinding.statusTextView.text = item.status.title(holder.itemView.resources)

        holder.itemView.setOnClickListener{
            filterSelectionManager.onSelectionFilter(item)
            notifyDataSetChanged()
        }
    }

    class ViewHolder(val filterItemBinding: FilterItemBinding):
        RecyclerView.ViewHolder(filterItemBinding.root)
}