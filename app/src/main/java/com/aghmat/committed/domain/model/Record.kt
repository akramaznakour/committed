package com.aghmat.committed.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "records")
data class Record(

    @PrimaryKey val id: Int,

    @ColumnInfo(name = "date") val date: LocalDateTime,

    @ColumnInfo(name = "habit_id") val habitId: Int,

)
