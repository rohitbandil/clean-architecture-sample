package com.example.clean_architecture.ui.di

import com.example.clean_architecture.domain.repository.Repository
import com.example.clean_architecture.domain.usecases.GetPost
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideGetPostUseCase(repository: Repository): GetPost {
        return GetPost(repository)
    }
}