package com.aghmat.committed.domain.usecase

import android.os.Build
import androidx.annotation.RequiresApi
import com.aghmat.committed.common.Resource
import com.aghmat.committed.domain.model.HabitWithRegularitiesAndRecords
import com.aghmat.committed.domain.repository.HabitRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetTodayHabitsWithRegularityAndRecords @Inject constructor(
    private val repository: HabitRepository
) {
    @RequiresApi(Build.VERSION_CODES.O)
    operator fun invoke(

    ): Flow<Resource<List<HabitWithRegularitiesAndRecords>>> = flow {
        try {
            emit(Resource.Loading<List<HabitWithRegularitiesAndRecords>>())
            val habitWithRegularityAndRecords = repository.getTodayHabitsWithRegularitiesAndRecords()
            emit(Resource.Success<List<HabitWithRegularitiesAndRecords>>(habitWithRegularityAndRecords))
        } catch (e: IOException) {
            emit(Resource.Error<List<HabitWithRegularitiesAndRecords>>("Unable to fetch habits"))
        }
    }
}
