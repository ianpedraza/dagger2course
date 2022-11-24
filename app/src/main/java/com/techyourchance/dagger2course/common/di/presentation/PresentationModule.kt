package com.techyourchance.dagger2course.common.di.presentation

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {
    @Provides
    fun providesViewMvcFactory(
        layoutInflater: LayoutInflater
    ): ViewMvcFactory = ViewMvcFactory(layoutInflater)

    @Provides
    fun providesDialogsNavigator(
        fragmentManager: FragmentManager
    ): DialogsNavigator = DialogsNavigator(fragmentManager)

    @Provides
    fun providesFetchQuestionsUseCase(
        stackoverflowApi: StackoverflowApi
    ): FetchQuestionsUseCase = FetchQuestionsUseCase(stackoverflowApi)

    @Provides
    fun providesFetchQuestionDetailsUseCase(
        stackoverflowApi: StackoverflowApi
    ): FetchQuestionDetailsUseCase = FetchQuestionDetailsUseCase(stackoverflowApi)
}
