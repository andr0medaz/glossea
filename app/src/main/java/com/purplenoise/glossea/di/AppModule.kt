//di/AppModule.kt

package com.purplenoise.glossea.di

import com.purplenoise.glossea.data.repository.LearningRepository
import com.purplenoise.glossea.data.repository.LearningRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindLearningRepository(
        impl: LearningRepositoryImpl
    ): LearningRepository
}