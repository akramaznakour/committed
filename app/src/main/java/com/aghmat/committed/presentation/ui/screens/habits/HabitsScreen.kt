package com.aghmat.committed.presentation.ui.screens.habits

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aghmat.committed.common.Resource
import com.aghmat.committed.domain.model.HabitWithRegularities
import com.aghmat.committed.presentation.ui.navigation.Screen
import com.aghmat.committed.presentation.ui.screens.days.TopAppBarSample

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HabitsScreen(
    navController: NavController,
    habitsViewModel: HabitsViewModel = hiltViewModel()
) {

    val habitsResource by habitsViewModel.habits.observeAsState()

    var screenState by remember { mutableStateOf(ScreenState.INITIAL) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {
            TopAppBarSample { navController.navigate(Screen.CreateHabit.route) }
            Text(
                text = "Habits",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(16.dp)
            )

            when (habitsResource) {
                is Resource.Success<List<HabitWithRegularities>> -> {
                    habitsResource?.let { it.data?.let { it1 -> HabitList(it1, navController) } }
                }
                else -> {
                    Text(
                        text = "Loading...",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }

            // This effect will refresh the list of habits when the screen state changes to REFRESH
            LaunchedEffect(screenState) {
                if (screenState == ScreenState.REFRESH) {
                    habitsViewModel.refreshHabits()
                    screenState = ScreenState.INITIAL
                }
            }
        }
    }

    // This effect will change the screen state to REFRESH when the screen becomes visible
    LaunchedEffect(Unit) {
        if (screenState == ScreenState.INITIAL) {
            screenState = ScreenState.REFRESH
        }
    }
}

@Composable
fun HabitList(habits: List<HabitWithRegularities>, navController: NavController) {
    LazyColumn {
        items(habits) { habit ->
            HabitListItem(habit, navController)
        }
    }
}

@Composable
fun HabitListItem(habit: HabitWithRegularities, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                // Navigate to habit details screen
            }
            .padding(16.dp)
    ) {
        Text(
            text = habit.habit.name,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.fillMaxWidth()
        )
        if (habit.regularities.isNotEmpty()) {
            Text(
                text = "Regularities: " + habit.regularities.joinToString(", ") { it.type.name },
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth()
            )
        } else {
            Text(
                text = "No regularities found",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}

enum class ScreenState {
    INITIAL,
    REFRESH
}
