package com.aghmat.committed.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "accounts")
data class Account(

    @PrimaryKey val id: Long?,

    @ColumnInfo(name = "date") val creationDate: LocalDateTime,

)
