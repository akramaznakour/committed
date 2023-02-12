package com.aghmat.committed.data.repository

import com.aghmat.committed.data.database.AppDatabase
import com.aghmat.committed.domain.model.Regularity
import com.aghmat.committed.domain.repository.RegularityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RegularityRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase
) : RegularityRepository {

    override suspend fun getRegularities() = appDatabase.habitRegularityDao().getAll()

    override suspend fun createRegularity(regularity: Regularity) = withContext(Dispatchers.IO) {
        appDatabase.habitRegularityDao().create(regularity)
    }
}
