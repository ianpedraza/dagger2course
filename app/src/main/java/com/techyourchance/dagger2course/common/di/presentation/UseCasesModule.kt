package com.techyourchance.dagger2course.common.di.presentation

import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {
    @Provides
    fun providesFetchQuestionsUseCase(
        stackoverflowApi: StackoverflowApi
    ): FetchQuestionsUseCase = FetchQuestionsUseCase(stackoverflowApi)

    @Provides
    fun providesFetchQuestionDetailsUseCase(
        stackoverflowApi: StackoverflowApi
    ): FetchQuestionDetailsUseCase = FetchQuestionDetailsUseCase(stackoverflowApi)
}
