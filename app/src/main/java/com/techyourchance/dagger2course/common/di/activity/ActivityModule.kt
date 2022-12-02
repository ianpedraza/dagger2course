package com.techyourchance.dagger2course.common.di.activity

import android.app.Activity
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.screens.common.DefaultScreensNavigator
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class ActivityModule {

    @ActivityScoped
    @Binds
    abstract fun providesScreensNavigator(
        screensNavigator: DefaultScreensNavigator
    ): ScreensNavigator

    companion object {
        /**
         * Take Care !!!
         * We can do this here because we're are using custom BaseActivity
         * which actually extends AppCompatActivity and we're confident
         * we don't have problems
         **/
        @Provides
        fun providesAppCompatActivity(
            activity: Activity
        ): AppCompatActivity = activity as AppCompatActivity

        @Provides
        fun providesLayoutInflater(
            activity: Activity
        ): LayoutInflater = LayoutInflater.from(activity)

        @Provides
        fun providesFragmentManager(
            activity: AppCompatActivity
        ): FragmentManager = activity.supportFragmentManager
    }
}
