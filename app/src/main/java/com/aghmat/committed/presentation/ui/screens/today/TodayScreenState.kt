package com.aghmat.committed.presentation.ui.screens.today

import com.aghmat.committed.domain.model.HabitWithRegularitiesAndRecords

data class TodayScreenState(
    val todayHabitsWithRegularityAndRecords: List<HabitWithRegularitiesAndRecords>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
