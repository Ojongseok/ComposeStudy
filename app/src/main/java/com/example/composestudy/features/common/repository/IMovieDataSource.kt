package com.example.composestudy.features.common.repository

import com.example.composestudy.features.common.entity.CategoryEntity
import com.example.composestudy.features.common.entity.EntityWrapper
import com.example.composestudy.features.common.entity.MovieDetailEntity
import com.example.composestudy.features.feed.domain.enum.SortOrder

interface IMovieDataSource {
    suspend fun getCategories(sortOrder: SortOrder? = null): EntityWrapper<List<CategoryEntity>>
    suspend fun getMovieDetail(movieName: String): MovieDetailEntity
}