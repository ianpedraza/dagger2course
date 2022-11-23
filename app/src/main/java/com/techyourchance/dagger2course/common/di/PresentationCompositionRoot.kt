package com.techyourchance.dagger2course.common.di

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory

class PresentationCompositionRoot(
    private val activityCompositionRoot: ActivityCompositionRoot
) {
    private val layoutInflater: LayoutInflater get() = activityCompositionRoot.layoutInflater

    private val fragmentManager: FragmentManager get() = activityCompositionRoot.fragmentManager

    private val stackoverflowApi: StackoverflowApi get() = activityCompositionRoot.stackoverflowApi

    val activity get() = activityCompositionRoot.activity

    val screensNavigator: ScreensNavigator get() = activityCompositionRoot.screensNavigator

    val viewMvcFactory: ViewMvcFactory get() = ViewMvcFactory(layoutInflater)

    val dialogsNavigator: DialogsNavigator get() = DialogsNavigator(fragmentManager)

    val fetchQuestionsUseCase: FetchQuestionsUseCase get() = FetchQuestionsUseCase(stackoverflowApi)

    val fetchQuestionDetailsUseCase: FetchQuestionDetailsUseCase
        get() = FetchQuestionDetailsUseCase(stackoverflowApi)
}
