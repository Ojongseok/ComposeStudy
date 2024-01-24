package com.example.composestudy.features.detail.domain.usecase

import com.example.composestudy.features.common.entity.MovieDetailEntity

interface IGetMovieDetailUseCase {
    suspend operator fun invoke(name: String): MovieDetailEntity
}
