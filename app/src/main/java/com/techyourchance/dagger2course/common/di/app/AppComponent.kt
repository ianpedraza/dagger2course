package com.techyourchance.dagger2course.common.di.app

import com.techyourchance.dagger2course.common.di.activity.ActivityComponent
import com.techyourchance.dagger2course.common.di.service.ServiceComponent
import com.techyourchance.dagger2course.common.di.service.ServiceModule
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun newActivityComponentBuilder(): ActivityComponent.Builder
    fun newServiceComponent(serviceModule: ServiceModule): ServiceComponent
}
