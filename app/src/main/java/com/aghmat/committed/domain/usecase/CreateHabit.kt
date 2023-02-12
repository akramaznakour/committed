package com.aghmat.committed.domain.usecase

import android.os.Build
import androidx.annotation.RequiresApi
import com.aghmat.committed.common.Resource
import com.aghmat.committed.domain.enums.RegularityType
import com.aghmat.committed.domain.model.Habit
import com.aghmat.committed.domain.model.Regularity
import com.aghmat.committed.domain.repository.HabitRepository
import com.aghmat.committed.domain.repository.RegularityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class CreateHabit @Inject constructor(
    private val habitRepository: HabitRepository,
    private val regularityRepository: RegularityRepository,
) {
    @RequiresApi(Build.VERSION_CODES.O)
    operator fun invoke(
        name: String,
        regularityTypes: List<RegularityType>,
    ): Flow<Resource<Habit>> = flow {
        try {
            emit(Resource.Loading<Habit>())

            val habit = habitRepository.createHabit(Habit(null, name))

            regularityTypes.forEach {
                regularityRepository.createRegularity(
                    Regularity(
                        null,
                        habit.id,
                        it
                    )
                )
            }

            emit(Resource.Success<Habit>(habit))
        } catch (e: IOException) {
            emit(Resource.Error<Habit>("Unable to create habit"))
        }
    }
}
