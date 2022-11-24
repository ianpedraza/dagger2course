package com.techyourchance.dagger2course.common.di.presentation

import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory
import dagger.Component

@Component(modules = [PresentationModule::class])
interface PresentationComponent {
    fun providesScreensNavigator(): ScreensNavigator
    fun providesViewMvcFactory(): ViewMvcFactory
    fun providesDialogsNavigator(): DialogsNavigator
    fun providesFetchQuestionsUseCase(): FetchQuestionsUseCase
    fun providesFetchQuestionDetailsUseCase(): FetchQuestionDetailsUseCase
}
