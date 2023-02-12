package com.aghmat.committed.data.database

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import com.aghmat.committed.domain.enums.RegularityType

object HabitRegularityTypeConverter {

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun toDate(dateString: String?): RegularityType? = when (dateString) {
        null -> null
        else -> RegularityType.valueOf(dateString)
    }

    @TypeConverter
    fun toDateString(date: RegularityType?): String? = date?.toString()
}
