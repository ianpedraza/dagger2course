package com.techyourchance.dagger2course.common.di

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(private val activityCompositionRoot: ActivityCompositionRoot) {

    @Provides
    fun layoutInflater(): LayoutInflater = activityCompositionRoot.layoutInflater

    @Provides
    fun fragmentManager(): FragmentManager = activityCompositionRoot.fragmentManager

    @Provides
    fun stackoverflowApi(): StackoverflowApi = activityCompositionRoot.stackoverflowApi

    @Provides
    fun activity() = activityCompositionRoot.activity

    @Provides
    fun screensNavigator(): ScreensNavigator = activityCompositionRoot.screensNavigator

    @Provides
    fun viewMvcFactory(
        layoutInflater: LayoutInflater
    ): ViewMvcFactory = ViewMvcFactory(layoutInflater)

    @Provides
    fun dialogsNavigator(
        fragmentManager: FragmentManager
    ): DialogsNavigator = DialogsNavigator(fragmentManager)

    @Provides
    fun fetchQuestionsUseCase(
        stackoverflowApi: StackoverflowApi
    ): FetchQuestionsUseCase = FetchQuestionsUseCase(stackoverflowApi)

    @Provides
    fun fetchQuestionDetailsUseCase(
        stackoverflowApi: StackoverflowApi
    ): FetchQuestionDetailsUseCase = FetchQuestionDetailsUseCase(stackoverflowApi)
}
