package com.example.composestudy.features.common.repository

interface IMovieDataSource {
    suspend fun getMovieList()
}