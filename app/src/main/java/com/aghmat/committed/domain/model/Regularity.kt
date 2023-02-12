package com.aghmat.committed.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aghmat.committed.domain.enums.RegularityType

@Entity(tableName = "regularities")
data class Regularity(

    @PrimaryKey val id: Long? ,

    @ColumnInfo(name = "habit_id") val habitId: Long? ,

    @ColumnInfo(name = "type") val type: RegularityType,

    )
