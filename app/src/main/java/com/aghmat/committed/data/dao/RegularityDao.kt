package com.aghmat.committed.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.aghmat.committed.domain.model.Regularity

@Dao
interface RegularityDao {

    @Query("SELECT * FROM regularities")
    suspend fun getAll(): List<Regularity>

    @Insert
    suspend fun create(vararg regularity: Regularity)

    @Update
    suspend fun update(vararg regularity: Regularity)

}
