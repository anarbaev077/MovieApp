package com.example.movieapp.data.base

import com.example.movieapp.data.base.model.AnotherError
import com.example.movieapp.data.base.model.ResultStatus
import retrofit2.HttpException
import retrofit2.Response

abstract class BasicDataSource {

    suspend fun <T> invokeResponseRequest(
        request: suspend () -> Response<T>
    ): ResultStatus<T> {
        return try {
            val response = request()
            if (response.isSuccessful) {
                ResultStatus.success(
                    data = response.body()!!
                )
            } else {
                ResultStatus.error(
                    errorThrowable = AnotherError(
                        errorMassage = response.message(),
                        code = response.code()
                    ),
                    data = null,
                )
            }
        } catch (httpException: HttpException) {
            ResultStatus.error(errorThrowable = httpException, data = null)
        } catch (e: Throwable) {
            ResultStatus.error(errorThrowable = e, data = null)
        }
    }
}