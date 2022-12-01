package com.techyourchance.dagger2course.common.di.presentation

import androidx.lifecycle.ViewModel
import com.techyourchance.dagger2course.common.di.ViewModelKey
import com.techyourchance.dagger2course.screens.viewmodel.MyViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel::class)
    abstract fun myViewModel(myViewModel: MyViewModel): ViewModel

    /*
    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel2::class
    abstract fun myViewModel(myViewModel2: MyViewModel2): ViewModel
    */
}
