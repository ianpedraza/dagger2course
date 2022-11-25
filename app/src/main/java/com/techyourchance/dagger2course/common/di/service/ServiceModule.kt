package com.techyourchance.dagger2course.common.di.service

import android.app.Service
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ServiceModule(private val service: Service) {
    @Provides
    fun providesContext(): Context = service
}
