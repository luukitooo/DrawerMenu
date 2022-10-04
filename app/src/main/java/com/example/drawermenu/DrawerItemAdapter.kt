package com.example.drawermenu

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.drawermenu.databinding.ItemDrawerSectionBinding

class DrawerItemAdapter: ListAdapter<DrawerItem, DrawerItemAdapter.DrawerItemViewHolder>(DrawerItemCallback) {

    var onItemClickListener: ((DrawerItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DrawerItemViewHolder(
        ItemDrawerSectionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: DrawerItemViewHolder, position: Int) {
        holder.bind()
    }

    inner class DrawerItemViewHolder(private val binding: ItemDrawerSectionBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val item = getItem(adapterPosition)
            binding.apply {
                if (item.isSelected) root.setCardBackgroundColor(Color.GRAY)
                else root.setCardBackgroundColor(Color.WHITE)
                ivSection.setImageResource(item.type.icon)
                tvTitle.text = item.type.title
                root.setOnClickListener {
                    onItemClickListener?.invoke(item)
                }
            }
        }
    }

    private object DrawerItemCallback: DiffUtil.ItemCallback<DrawerItem>() {
        override fun areItemsTheSame(oldItem: DrawerItem, newItem: DrawerItem): Boolean {
            return oldItem.type == newItem.type
        }

        override fun areContentsTheSame(oldItem: DrawerItem, newItem: DrawerItem): Boolean {
            return oldItem == newItem
        }
    }

}