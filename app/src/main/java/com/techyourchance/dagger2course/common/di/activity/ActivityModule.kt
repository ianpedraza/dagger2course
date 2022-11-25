package com.techyourchance.dagger2course.common.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.screens.common.DefaultScreensNavigator
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule {

    @ActivityScope
    @Binds
    abstract fun providesScreensNavigator(
        screensNavigator: DefaultScreensNavigator
    ): ScreensNavigator

    companion object {
        @Provides
        fun providesLayoutInflater(
            activity: AppCompatActivity
        ): LayoutInflater = LayoutInflater.from(activity)

        @Provides
        fun providesFragmentManager(
            activity: AppCompatActivity
        ): FragmentManager = activity.supportFragmentManager
    }
}
