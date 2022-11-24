package com.techyourchance.dagger2course.common.di.app

import android.app.Application
import com.techyourchance.dagger2course.networking.StackoverflowApi
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun providesApplication(): Application
    fun providesStackoverflowApi(): StackoverflowApi
}
