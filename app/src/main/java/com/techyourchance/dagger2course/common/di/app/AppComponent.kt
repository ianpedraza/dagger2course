package com.techyourchance.dagger2course.common.di.app

import com.techyourchance.dagger2course.common.di.activity.ActivityComponent
import com.techyourchance.dagger2course.common.di.activity.ActivityModule
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent
}
