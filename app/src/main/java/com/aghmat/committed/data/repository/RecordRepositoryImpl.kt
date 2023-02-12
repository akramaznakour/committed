package com.aghmat.committed.data.repository

import com.aghmat.committed.data.database.AppDatabase
import com.aghmat.committed.domain.model.Record
import com.aghmat.committed.domain.repository.RecordRepository
import javax.inject.Inject

class RecordRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase
) : RecordRepository {

    override suspend fun getHabitRecords() = appDatabase.habitRecordDao().getAll()

    override suspend fun createHabitRecord(record: Record) =
        appDatabase.habitRecordDao().create(record)

}
