package com.example.composestudy.features.common.mapper

import com.example.composestudy.features.common.entity.EntityWrapper
import com.example.composestudy.library.network.model.ApiResponse
import com.example.composestudy.library.network.model.ApiResult

abstract class BaseMapper<M, E> {
    fun mapFromResult(result: ApiResult<M>, extra: Any? = null): EntityWrapper<E> =
        when (result.response) {
            is ApiResponse.Success -> getSuccess(model = result.response.data, extra = extra)
            is ApiResponse.Fail -> getFailure(error = result.response.error)
        }

    abstract fun getSuccess(model: M?, extra: Any?): EntityWrapper.Success<E>

    abstract fun getFailure(error: Throwable): EntityWrapper.Fail<E>
}
