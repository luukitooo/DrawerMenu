package com.example.drawermenu

data class DrawerItem(
    val isSelected: Boolean,
    val type: ItemTypes
)

enum class ItemTypes(val icon: Int, val title: String) {
    DASHBOARD(R.drawable.dashboard, "Dashboard"),
    POST(R.drawable.post, "Post"),
    NOTIFICATIONS(R.drawable.notifications, "Notifications"),
    CALENDAR(R.drawable.calendar, "Calendar"),
    STATISTICS(R.drawable.statistics, "Statistics"),
    SETTINGS(R.drawable.settings, "Settings")
}

