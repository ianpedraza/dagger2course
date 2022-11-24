package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.common.di.activity.ActivityComponent
import com.techyourchance.dagger2course.common.di.activity.ActivityModule
import com.techyourchance.dagger2course.common.di.activity.DaggerActivityComponent
import com.techyourchance.dagger2course.common.di.app.AppComponent
import com.techyourchance.dagger2course.common.di.app.AppModule
import com.techyourchance.dagger2course.common.di.app.DaggerAppComponent
import com.techyourchance.dagger2course.common.di.presentation.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.di.presentation.PresentationComponent
import com.techyourchance.dagger2course.common.di.presentation.PresentationModule

open class BaseActivity : AppCompatActivity() {
    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(application))
            .build()
    }

    val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this, appComponent))
            .build()
    }

    private val presentationComponent: PresentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityComponent))
            .build()
    }

    protected val injector get() = presentationComponent
}
