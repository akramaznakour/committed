package com.aghmat.committed.domain.repository

import com.aghmat.committed.domain.model.Regularity


interface RegularityRepository {

    suspend fun getRegularities(): List<Regularity>

    suspend fun createRegularity(regularity: Regularity)

}
