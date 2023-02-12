package com.aghmat.committed.presentation.ui.screens.today

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aghmat.committed.presentation.theme.GreenShare1

@RequiresApi(Build.VERSION_CODES.O)
@Composable
public fun TodayScreen(
    navController: NavController,
) {

    val viewModel: TodayViewModel = hiltViewModel()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            Modifier.padding(16.dp),
        ) {
            Text(
                text = "Today",
                fontSize = 48.sp,
                modifier = Modifier.padding(0.dp, 4.dp)
            )
            Text(
                text = "If you are going ...",
                fontSize = 16.sp,
                modifier = Modifier.padding(0.dp, 4.dp)
            )

            BigHabitSquare()
            HabitSquare(name = "Habit ...")
        }
    }
}

@Composable
public fun BigHabitSquare(modifier: Modifier = Modifier,) {
    Card(
        backgroundColor = GreenShare1,
        modifier = Modifier
            .padding(0.dp, 24.dp)
            .width(200.dp)
            .height(200.dp),
        shape = RoundedCornerShape(50.dp)
    ) {
    }
}

@Composable
public fun HabitSquare(modifier: Modifier = Modifier, name: String) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Bottom,
        modifier = modifier.padding(0.dp, 8.dp)
    ) {
        Card(
            backgroundColor = GreenShare1,
            modifier = Modifier
                .padding(0.dp, 0.dp)
                .width(50.dp)
                .height(50.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
        }
        Text(
            text = name,
            fontSize = 24.sp,
            modifier = Modifier.padding(8.dp, 0.dp)
        )
    }
}
