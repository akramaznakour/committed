package com.aghmat.committed.domain.repository

import com.aghmat.committed.domain.model.Habit
import com.aghmat.committed.domain.model.HabitWithRegularities
import com.aghmat.committed.domain.model.HabitWithRegularitiesAndRecords


interface HabitRepository {

    suspend fun getHabits(): List<Habit>

    suspend fun createHabit(habit: Habit): Habit

    fun getTodayHabitsWithRegularitiesAndRecords(): List<HabitWithRegularitiesAndRecords>

    suspend fun getHabitsWithRegularities(): List<HabitWithRegularities>
}
