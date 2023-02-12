package com.aghmat.committed.presentation.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

const val TODAY_SCREEN_ROUTE = "today_screen"
const val DAYS_SCREEN_ROUTE = "days_screen"
const val HABITS_SCREEN_ROUTE = "habits_screen_route"
const val SETTINGS_SCREEN_ROUTE = "settings_screen"
const val CREATE_HABIT_SCREEN_ROUTE = "create_habit_screen"

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Today : Screen(TODAY_SCREEN_ROUTE, "Today", Icons.Default.Home)
    object Days : Screen(DAYS_SCREEN_ROUTE, "Days", Icons.Default.List)
    object Habits : Screen(HABITS_SCREEN_ROUTE, "Habits", Icons.Default.List)
    object Settings : Screen(SETTINGS_SCREEN_ROUTE, "Settings", Icons.Default.Settings)
    object CreateHabit : Screen(CREATE_HABIT_SCREEN_ROUTE, "Create habit", Icons.Default.Add)
}
