package com.techyourchance.dagger2course.questions

import com.techyourchance.dagger2course.Constants
import com.techyourchance.dagger2course.networking.StackoverflowApi
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FetchQuestionsUseCase {

    // init retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val stackoverflowApi: StackoverflowApi = retrofit.create(StackoverflowApi::class.java)

    suspend fun fetchLatestQuestion(): DataState<List<Question>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = stackoverflowApi.lastActiveQuestions(20)
                if (response.isSuccessful && response.body() != null) {
                    return@withContext DataState.Success(response.body()!!.questions)
                } else {
                    return@withContext DataState.Failure
                }
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    return@withContext DataState.Failure
                } else {
                    throw t
                }
            }
        }
    }

    sealed class DataState<out R> {
        data class Success<out T>(val data: T) : DataState<T>()
        object Failure : DataState<Nothing>()
    }
}
