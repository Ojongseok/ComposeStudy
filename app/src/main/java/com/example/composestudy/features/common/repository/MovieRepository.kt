package com.example.composestudy.features.common.repository

import com.example.composestudy.features.common.entity.CategoryEntity
import com.example.composestudy.features.common.entity.EntityWrapper
import com.example.composestudy.features.common.entity.MovieDetailEntity
import com.example.composestudy.features.common.network.api.IMovieAppNetworkApi
import com.example.composestudy.features.feed.data.FeedConstants
import com.example.composestudy.features.feed.data.mapper.CategoryMapper
import com.example.composestudy.features.feed.domain.enum.SortOrder
import kr.co.fastcampus.part4plus.movieapp.library.storage.IStorage
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieNetworkApi: IMovieAppNetworkApi,
    private val storage: IStorage,
    private val categoryMapper: CategoryMapper
): IMovieDataSource {
    override suspend fun getCategories(sortOrder: SortOrder?): EntityWrapper<List<CategoryEntity>> {
        return categoryMapper.mapFromResult(
            result = movieNetworkApi.getMovies(),
            extra = sortOrder
        )
    }

    override suspend fun getMovieDetail(movieName: String): MovieDetailEntity {
        return storage
            .get<List<MovieDetailEntity>>(FeedConstants.MOVIE_LIST_KEY)
            ?.single { it.title == movieName }
            ?: MovieDetailEntity()
    }
}