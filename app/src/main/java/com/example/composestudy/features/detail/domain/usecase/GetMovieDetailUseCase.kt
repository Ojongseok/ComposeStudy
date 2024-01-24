package com.example.composestudy.features.detail.domain.usecase

import com.example.composestudy.features.common.entity.MovieDetailEntity
import com.example.composestudy.features.common.repository.IMovieDataSource
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val dataSource: IMovieDataSource
) : IGetMovieDetailUseCase {
    override suspend fun invoke(name: String): MovieDetailEntity {
        return dataSource.getMovieDetail(name)
    }
}
