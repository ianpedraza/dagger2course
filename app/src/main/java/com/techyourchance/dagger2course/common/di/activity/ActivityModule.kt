package com.techyourchance.dagger2course.common.di.activity

import android.app.Application
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.common.di.app.AppComponent
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    private val activity: AppCompatActivity,
    private val appComponent: AppComponent
) {
    @Provides
    fun providesActivity(): AppCompatActivity = activity

    @Provides
    fun providesApplication(): Application = appComponent.providesApplication()

    @Provides
    @ActivityScope
    fun providesScreensNavigator(): ScreensNavigator = ScreensNavigator(activity)

    @Provides
    fun providesLayoutInflater(): LayoutInflater = LayoutInflater.from(activity)

    @Provides
    fun providesFragmentManager(): FragmentManager = activity.supportFragmentManager

    @Provides
    fun providesStackoverflowApi(): StackoverflowApi = appComponent.providesStackoverflowApi()
}
