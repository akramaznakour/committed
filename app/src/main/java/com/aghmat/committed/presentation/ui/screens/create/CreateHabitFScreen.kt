package com.aghmat.committed.presentation.ui.screens.create

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aghmat.committed.R
import com.aghmat.committed.domain.enums.RegularityType
import com.aghmat.committed.presentation.theme.GreenShare1
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CreateHabitFScreen(navController: NavController) {
    val habitName = remember {
        mutableStateOf("")
    }

    val regularityTypeWithStatuses =
        RegularityType.values().map { RegularityTypeWithStatus(it, false) }

    val viewModel: CreateHabitViewModel = hiltViewModel()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column() {
            CreateHabitScreenTopAppBar { navController.popBackStack() }
            CreateHabitForm(
                habitName = habitName.value,
                onHabitNameChanged = { habitName.value = it },
                regularityTypeWithStatuses = regularityTypeWithStatuses,
                onSaveHabit = {
                    viewModel.createHabit(habitName.value, regularityTypeWithStatuses)
                    navController.popBackStack()
                }
            )
        }
    }
}

@Composable
fun CreateHabitScreenTopAppBar(onClick: () -> Unit) {
    Column {
        TopAppBar(
            elevation = 0.dp,
            title = {},
            backgroundColor = MaterialTheme.colors.primarySurface,
            navigationIcon = {
                IconButton(onClick) {
                    Icon(Icons.Filled.ArrowBack, "back")
                }
            }
        )
    }
}

@Composable
fun CreateHabitForm(
    habitName: String,
    onHabitNameChanged: (String) -> Unit,
    regularityTypeWithStatuses: List<RegularityTypeWithStatus>,
    onSaveHabit: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.screen_create_habit_name_label),
            fontSize = 24.sp,
            modifier = Modifier.padding(8.dp)
        )
        OutlinedTextField(
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            value = habitName,
            onValueChange = { onHabitNameChanged(it) },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                disabledTextColor = Color.Transparent,
                backgroundColor = Color.Black,
                focusedIndicatorColor = GreenShare1,
                unfocusedIndicatorColor = Color.White,
                disabledIndicatorColor = Color.White
            )
        )
        Text(
            text = stringResource(R.string.screen_create_habit_regularity_label),
            fontSize = 24.sp,
            modifier = Modifier.padding(8.dp)
        )
        RegularityTypesWithStatusGrid(regularityTypeWithStatuses)
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedButton(
                onClick = onSaveHabit,
                modifier = Modifier
                    .padding(0.dp, 48.dp),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, GreenShare1),
            ) {
                Text(
                    stringResource(R.string.general_button_confirm),
                    modifier = Modifier.padding(4.dp, 2.dp),
                    color = Color.White,
                    fontSize = 24.sp,
                )
            }
        }
    }
}

@Composable
fun RegularityTypesWithStatusGrid(
    regularityTypesWithStatuses: List<RegularityTypeWithStatus>,
) {

    FlowRow(
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 0.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        mainAxisAlignment = MainAxisAlignment.Start
    ) {
        regularityTypesWithStatuses.forEachIndexed { index, item ->
            RegularityTypeWithStatusChip(item) {
                item.selected = !item.selected;
            }
        }
    }
}


@Composable
fun RegularityTypeWithStatusChip(
    regularityTypeWithStatus: RegularityTypeWithStatus,
    onChecked: () -> Unit,
) {
    val isSelected = remember { mutableStateOf(regularityTypeWithStatus.selected) }

    OutlinedButton(
        onClick = {
            isSelected.value = !isSelected.value
            onChecked()
        },
        modifier = Modifier.padding(0.dp, 0.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(
            width = 1.dp,
            color = if (isSelected.value) GreenShare1 else Color.White
        ),
    ) {
        Text(
            stringResource(id = regularityTypeWithStatus.regularityType.resource),
            modifier = Modifier.padding(0.dp, 0.dp),
            color = Color.White,
            fontSize = 18.sp,
        )
    }
}
