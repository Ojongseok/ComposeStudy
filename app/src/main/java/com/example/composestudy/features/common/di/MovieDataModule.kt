package com.example.composestudy.features.common.di

import com.example.composestudy.features.common.network.api.IMovieAppNetworkApi
import com.example.composestudy.features.common.network.api.MovieAppNetworkApi
import com.example.composestudy.features.common.repository.IMovieDataSource
import com.example.composestudy.features.common.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieDataModule {

    @Singleton
    @Binds
    abstract fun bindMovieRepository(movieRepository: MovieRepository): IMovieDataSource

    @Singleton
    @Binds
    abstract fun bindNetwork(networkApi: MovieAppNetworkApi): IMovieAppNetworkApi

}
