package com.techyourchance.dagger2course.common.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {
    @Provides
    fun providesActivity(): AppCompatActivity = activity

    @ActivityScope
    @Provides
    fun screensNavigator(activity: AppCompatActivity): ScreensNavigator = ScreensNavigator(activity)

    @Provides
    fun providesLayoutInflater(): LayoutInflater = LayoutInflater.from(activity)

    @Provides
    fun providesFragmentManager(): FragmentManager = activity.supportFragmentManager
}
