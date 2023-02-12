package com.aghmat.committed.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aghmat.committed.data.dao.HabitDao
import com.aghmat.committed.data.dao.RecordDao
import com.aghmat.committed.data.dao.RegularityDao
import com.aghmat.committed.domain.model.Habit
import com.aghmat.committed.domain.model.Record
import com.aghmat.committed.domain.model.Regularity

@TypeConverters(LocalDateTimeConverter::class, HabitRegularityTypeConverter::class)
@Database(entities = [Habit::class, Record::class, Regularity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
    abstract fun habitRecordDao(): RecordDao
    abstract fun habitRegularityDao(): RegularityDao
}
