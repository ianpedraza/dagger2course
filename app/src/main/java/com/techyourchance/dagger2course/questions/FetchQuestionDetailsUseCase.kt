package com.techyourchance.dagger2course.questions

import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.common.DataState
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FetchQuestionDetailsUseCase @Inject constructor(private val stackoverflowApi: StackoverflowApi) {

    suspend fun fetchQuestionDetails(questionId: String): DataState<QuestionWithBody> {
        return withContext(Dispatchers.IO) {
            try {
                val response = stackoverflowApi.questionDetails(questionId)
                if (response.isSuccessful && response.body() != null) {
                    val questionBody = response.body()!!.question
                    return@withContext DataState.Success(questionBody)
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
