package com.aghmat.committed.presentation.ui.screens.days

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aghmat.committed.presentation.theme.GreenShare1

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DaysScreen(navController: NavController) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {
            Column(
                Modifier.padding(16.dp),
            ) {
                Text(
                    text = "All days",
                    fontSize = 48.sp,
                    modifier = Modifier.padding(0.dp, 4.dp)
                )
                LazyVerticalGridDemo()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyVerticalGridDemo() {
    val list = (1..100).map { it.toString() }

    LazyVerticalGrid(
        cells = GridCells.Adaptive(54.dp),

        // content padding
        contentPadding = PaddingValues(
            start = 0.dp,
            top = 0.dp,
            end = 0.dp,
            bottom = 0.dp
        ),
        content = {
            items(list.size) { index ->
                HabitSquare()
            }
        }
    )
}


@Composable
fun TopAppBarSample(onClick: () -> Unit) {
    Column {
        TopAppBar(
            elevation = 0.dp,
            title = {},
            backgroundColor = MaterialTheme.colors.primarySurface,
            actions = {
                IconButton(onClick) {
                    Icon(Icons.Filled.AddCircle, null)
                }
            })
    }
}

@Composable
fun HabitSquare(modifier: Modifier = Modifier) {
    Card(
        backgroundColor = GreenShare1,
        modifier = Modifier
            .padding(4.dp)
            .width(50.dp)
            .height(50.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
    }
}
