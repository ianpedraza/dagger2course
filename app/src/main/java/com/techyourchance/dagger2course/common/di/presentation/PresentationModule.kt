package com.techyourchance.dagger2course.common.di.presentation

import androidx.savedstate.SavedStateRegistryOwner
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(private val savedStateRegistryOwner: SavedStateRegistryOwner) {
    @Provides
    fun providesSavedStateRegistryOwner() = savedStateRegistryOwner
}
