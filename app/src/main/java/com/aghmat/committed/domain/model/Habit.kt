package com.aghmat.committed.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habits")
data class Habit(

    @PrimaryKey val id: Long?,

    @ColumnInfo(name = "name") val name: String,

    )
