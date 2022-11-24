package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.common.di.activity.ActivityComponent
import com.techyourchance.dagger2course.common.di.activity.ActivityModule
import com.techyourchance.dagger2course.common.di.app.AppComponent
import com.techyourchance.dagger2course.common.di.app.AppModule
import com.techyourchance.dagger2course.common.di.app.DaggerAppComponent
import com.techyourchance.dagger2course.common.di.presentation.PresentationComponent

open class BaseActivity : AppCompatActivity() {
    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(application))
            .build()
    }

    val activityComponent: ActivityComponent by lazy {
        appComponent.newActivityComponent(ActivityModule(this))
    }

    private val presentationComponent: PresentationComponent by lazy {
        activityComponent.newPresentationComponent()
    }

    protected val injector get() = presentationComponent
}
