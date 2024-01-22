package com.example.composestudy.features.feed.domain.usecase

import com.example.composestudy.features.common.entity.CategoryEntity
import com.example.composestudy.features.common.entity.EntityWrapper
import com.example.composestudy.features.feed.domain.enum.SortOrder

interface IGetFeedCategoryUseCase {
    suspend operator fun invoke(sortOrder: SortOrder? = null): EntityWrapper<List<CategoryEntity>>
}