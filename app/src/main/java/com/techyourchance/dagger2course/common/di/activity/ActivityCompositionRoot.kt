package com.techyourchance.dagger2course.common.di.activity

import android.app.Application
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.common.di.app.AppCompositionRoot
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.screens.common.ScreensNavigator

class ActivityCompositionRoot(
    val activity: AppCompatActivity,
    private val appCompositionRoot: AppCompositionRoot
) {
    val screensNavigator: ScreensNavigator by lazy {
        ScreensNavigator(activity)
    }

    val application: Application get() = appCompositionRoot.application

    val layoutInflater: LayoutInflater get() = LayoutInflater.from(activity)

    val fragmentManager: FragmentManager get() = activity.supportFragmentManager

    val stackoverflowApi: StackoverflowApi get() = appCompositionRoot.stackoverflowApi
}
