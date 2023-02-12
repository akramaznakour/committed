package com.aghmat.committed.data.dao

import androidx.room.*
import com.aghmat.committed.domain.model.Record

@Dao
interface RecordDao {

    @Query("SELECT * FROM records")
    suspend fun getAll(): List<Record>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(vararg record: Record)

    @Update
    suspend fun update(vararg record: Record)

}
