package com.aghmat.committed.data.repository

import com.aghmat.committed.data.database.AppDatabase
import com.aghmat.committed.domain.model.Habit
import com.aghmat.committed.domain.model.HabitWithRegularities
import com.aghmat.committed.domain.model.HabitWithRegularitiesAndRecords
import com.aghmat.committed.domain.repository.HabitRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HabitRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase,
) : HabitRepository {

    override suspend fun getHabits() = appDatabase.habitDao().getAll()

    override suspend fun createHabit(habit: Habit): Habit = withContext(Dispatchers.IO) {
        val habitId = appDatabase.habitDao().create(habit)
        appDatabase.habitDao().getById(habitId)
    }

    override suspend fun getHabitsWithRegularities(): List<HabitWithRegularities> =
        withContext(Dispatchers.IO) {
            return@withContext appDatabase.habitDao().getHabitsWithRegularities()
        }

    override fun getTodayHabitsWithRegularitiesAndRecords(): List<HabitWithRegularitiesAndRecords> {
        return appDatabase.habitDao().getTodayHabitsWithRegularityAndRecords()
    }
}
