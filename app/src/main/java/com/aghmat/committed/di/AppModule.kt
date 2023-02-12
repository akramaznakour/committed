package com.aghmat.committed.di

import android.content.Context
import androidx.room.Room
import com.aghmat.committed.data.database.AppDatabase
import com.aghmat.committed.data.repository.HabitRepositoryImpl
import com.aghmat.committed.data.repository.RegularityRepositoryImpl
import com.aghmat.committed.domain.repository.HabitRepository
import com.aghmat.committed.domain.repository.RegularityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHabitRepository(appDatabase: AppDatabase): HabitRepository {
        return HabitRepositoryImpl(appDatabase)
    }

    @Provides
    @Singleton
    fun provideRegularityRepository(appDatabase: AppDatabase): RegularityRepository {
        return RegularityRepositoryImpl(appDatabase)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(appContext, AppDatabase::class.java, "committed-db").build()
    }
}
