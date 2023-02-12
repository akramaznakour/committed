package com.aghmat.committed.domain.repository

import com.aghmat.committed.domain.model.Record


interface RecordRepository {

    suspend fun getHabitRecords(): List<Record>

    suspend fun createHabitRecord(record: Record)

}
