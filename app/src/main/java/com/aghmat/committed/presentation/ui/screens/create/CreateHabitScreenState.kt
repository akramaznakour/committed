package com.aghmat.committed.presentation.ui.screens.create

import com.aghmat.committed.domain.enums.RegularityType
import com.aghmat.committed.domain.model.Habit

data class CreateHabitScreenState(
    val habitName: String = String(),
    val regularityTypes: List<RegularityType> = listOf(RegularityType.EVERY_DAY),
    val isLoading: Boolean = false,
    val error: String? = null,
    val createdHabit: Habit? = null,
)
