package com.techyourchance.dagger2course.common.di.activity

import com.techyourchance.dagger2course.common.di.presentation.PresentationComponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun newPresentationComponent(): PresentationComponent
}
