package com.techyourchance.dagger2course.common.service

import android.app.Service
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.di.app.AppComponent
import com.techyourchance.dagger2course.common.di.service.ServiceComponent
import com.techyourchance.dagger2course.common.di.service.ServiceModule

abstract class BaseService : Service() {
    private val appComponent: AppComponent get() = (application as MyApplication).appComponent

    val serviceComponent: ServiceComponent by lazy {
        appComponent.newServiceComponent(ServiceModule(this))
    }
}
