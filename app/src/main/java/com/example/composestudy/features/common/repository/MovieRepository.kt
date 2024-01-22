package com.example.composestudy.features.common.repository

import com.example.composestudy.features.common.network.api.IMovieAppNetworkApi
import com.example.composestudy.library.network.model.ApiResponse
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieNetworkApi: IMovieAppNetworkApi
): IMovieDataSource {
    override suspend fun getMovieList() {
        val data = movieNetworkApi.getMovies().response

        if (data is ApiResponse.Success) {
            val movieList = data.data

        }
    }
}