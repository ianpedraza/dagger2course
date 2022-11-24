package com.techyourchance.dagger2course.common.di.activity

import android.app.Application
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import dagger.Component

@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun providesActivity(): AppCompatActivity
    fun providesScreensNavigator(): ScreensNavigator
    fun providesApplication(): Application
    fun providesLayoutInflater(): LayoutInflater
    fun providesFragmentManager(): FragmentManager
    fun providesStackoverflowApi(): StackoverflowApi
}
