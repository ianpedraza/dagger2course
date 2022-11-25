package com.techyourchance.dagger2course.common.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Module
import dagger.Provides

@Module
object ActivityModule {
    @ActivityScope
    @Provides
    fun providesScreensNavigator(
        activity: AppCompatActivity
    ): ScreensNavigator = ScreensNavigator(activity)

    @Provides
    fun providesLayoutInflater(
        activity: AppCompatActivity
    ): LayoutInflater = LayoutInflater.from(activity)

    @Provides
    fun providesFragmentManager(
        activity: AppCompatActivity
    ): FragmentManager = activity.supportFragmentManager
}
