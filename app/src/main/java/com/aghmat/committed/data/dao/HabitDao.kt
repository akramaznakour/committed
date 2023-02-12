package com.aghmat.committed.data.dao

import androidx.room.*
import com.aghmat.committed.domain.model.Habit
import com.aghmat.committed.domain.model.HabitWithRegularities
import com.aghmat.committed.domain.model.HabitWithRegularitiesAndRecords

@Dao
interface HabitDao {

    @Query("SELECT * FROM  habits  WHERE id = :habitId LIMIT 1")
    fun getById(habitId: Long): Habit

    @Transaction
    @Query("SELECT * FROM habits")
    suspend fun getHabitsWithRegularities(): List<HabitWithRegularities>

    @Query("SELECT * FROM  habits")
    suspend fun getAll(): List<Habit>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun create(habit: Habit): Long

    @Update
    suspend fun update(habit: Habit)

    @Transaction
    @Query("SELECT * FROM  habits")
    fun getTodayHabitsWithRegularityAndRecords(): List<HabitWithRegularitiesAndRecords>

}
