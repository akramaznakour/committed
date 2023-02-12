package com.aghmat.committed.presentation.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aghmat.committed.presentation.ui.screens.create.CreateHabitFScreen
import com.aghmat.committed.presentation.ui.screens.days.DaysScreen
import com.aghmat.committed.presentation.ui.screens.habits.HabitsScreen
import com.aghmat.committed.presentation.ui.screens.settings.SettingScreen
import com.aghmat.committed.presentation.ui.screens.today.TodayScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.Days.route) {
        composable(
                route = Screen.Days.route,
        ) {
            DaysScreen(navHostController)
        }
        composable(
                route = Screen.Habits.route,
        ) {
            HabitsScreen(navHostController)
        }
        composable(route = Screen.Today.route) {
            TodayScreen(navHostController)
        }
        composable(route = Screen.Settings.route) {
            SettingScreen(navHostController)
        }
        composable(route = Screen.CreateHabit.route) {
            CreateHabitFScreen(navHostController)
        }
    }
}
