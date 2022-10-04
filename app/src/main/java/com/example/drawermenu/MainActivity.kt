package com.example.drawermenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.drawermenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val drawerItemAdapter = DrawerItemAdapter()

    private val drawerItems = MutableList(ItemTypes.values().size) { index ->
        DrawerItem(index == 0, ItemTypes.values()[index])
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        onClickListeners()

    }

    private fun init() {
        binding.rvDrawerItems.apply {
            adapter = drawerItemAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        drawerItemAdapter.submitList(drawerItems.toList())
    }

    private fun onClickListeners() {
        drawerItemAdapter.onItemClickListener = { clickedItem ->
            handleDrawerItemClick(clickedItem)
        }
    }

    private fun handleDrawerItemClick(clickedItem: DrawerItem) {
        val newList = mutableListOf<DrawerItem>()
        drawerItems.forEach { item ->
            newList.add(item.copy(isSelected = clickedItem.type == item.type))
        }
        drawerItemAdapter.submitList(newList.toList())
    }

}