package com.techyourchance.dagger2course.questions

import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.common.DataState
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FetchQuestionsUseCase @Inject constructor(private val stackoverflowApi: StackoverflowApi) {

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
}
