package com.aghmat.committed.domain.model

import androidx.room.Embedded
import androidx.room.Relation

data class HabitWithRegularitiesAndRecords(

    @Embedded
    val habit: Habit,

    @Relation(
        parentColumn = "id",
        entityColumn = "habit_id"
    )
    val regularities: List<Regularity>,

    @Relation(
        parentColumn = "id",
        entityColumn = "habit_id"
    )
    val records: List<Record>

)
