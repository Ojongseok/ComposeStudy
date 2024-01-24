package com.example.composestudy.features.feed.domain.di

import com.example.composestudy.features.feed.domain.usecase.GetFeedCategoryUseCase
import com.example.composestudy.features.feed.domain.usecase.IGetFeedCategoryUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FeedUseCaseModule {

    @Singleton
    @Binds
    abstract fun bindGetMovieListUseCase(getMovieListUseCase: GetFeedCategoryUseCase): IGetFeedCategoryUseCase
}
