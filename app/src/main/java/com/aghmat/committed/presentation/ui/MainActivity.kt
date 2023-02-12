package com.aghmat.committed.presentation.ui

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aghmat.committed.presentation.ui.navigation.Screen
import com.aghmat.committed.presentation.ui.navigation.SetupNavGraph
import com.aghmat.committed.presentation.theme.CommittedTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            val navController = rememberNavController()

            CommittedTheme {
                Scaffold(
                        bottomBar = { BottomBar(navController = navController) }
                ) {
                    navController
                    SetupNavGraph(navHostController = navController)
                }
            }
        }
    }
}


@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
            Screen.Days,
            Screen.Habits,
            Screen.Today,
            Screen.Settings,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
            backgroundColor = Color.Black,
            contentColor = Color.White,
    ) {
        screens.forEach { screen ->
            AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
        screen: Screen,
        currentDestination: NavDestination?,
        navController: NavHostController
) {
    BottomNavigationItem(
            label = {
                Text(text = screen.title)
            },
            icon = {
                Icon(
                        imageVector = screen.icon,
                        contentDescription = "Navigation Icon"
                )
            },
            selected = currentDestination?.hierarchy?.any {
                it.route == screen.route
            } == true,
            unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
            onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            }
    )
}




