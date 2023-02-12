package com.aghmat.committed.domain.usecase

import com.aghmat.committed.common.Resource
import com.aghmat.committed.domain.model.HabitWithRegularities
import com.aghmat.committed.domain.repository.HabitRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetHabitsWithRegularities @Inject constructor(
    private val habitRepository: HabitRepository
) {
    operator fun invoke(): Flow<Resource<List<HabitWithRegularities>>> = flow {
        try {
            emit(Resource.Loading())

            val habits = habitRepository.getHabitsWithRegularities()

            emit(Resource.Success(habits))
        } catch (e: IOException) {
            emit(Resource.Error("Unable to get habits"))
        }
    }
}
