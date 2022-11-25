package com.techyourchance.dagger2course.common.di.activity

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.common.di.presentation.PresentationComponent
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun newPresentationComponent(): PresentationComponent

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder

        /*
        The activityModule could be skipped, because remember:
        Dagger knows how to build non-parameterized Module
        */
        fun activityModule(activityModule: ActivityModule): Builder
        fun build(): ActivityComponent
    }
}
