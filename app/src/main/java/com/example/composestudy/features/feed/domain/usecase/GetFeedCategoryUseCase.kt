package com.example.composestudy.features.feed.domain.usecase

import com.example.composestudy.features.common.entity.CategoryEntity
import com.example.composestudy.features.common.entity.EntityWrapper
import com.example.composestudy.features.common.repository.IMovieDataSource
import com.example.composestudy.features.feed.domain.enum.SortOrder
import javax.inject.Inject

class GetFeedCategoryUseCase @Inject constructor(
    private val dataSource: IMovieDataSource
): IGetFeedCategoryUseCase {
    override suspend fun invoke(sortOrder: SortOrder?): EntityWrapper<List<CategoryEntity>> {
        return dataSource.getCategories(sortOrder)
    }
}