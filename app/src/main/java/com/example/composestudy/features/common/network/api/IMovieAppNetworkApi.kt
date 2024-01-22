package com.example.composestudy.features.common.network.api

import com.example.composestudy.features.common.network.model.MovieResponse
import com.example.composestudy.library.network.model.ApiResult

interface IMovieAppNetworkApi {
    suspend fun getMovies() : ApiResult<List<MovieResponse>>
}