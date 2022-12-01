package com.techyourchance.dagger2course.screens.common.viewmodels

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.viewmodel.MyViewModel
import javax.inject.Inject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(
    // private val providers: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
    private val fetchQuestionsUseCaseProvider: Provider<FetchQuestionsUseCase>,
    savedStateRegistryOwner: SavedStateRegistryOwner
) : AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null) {

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return when (modelClass) {
            MyViewModel::class.java -> MyViewModel(handle, fetchQuestionsUseCaseProvider.get()) as T
            else -> throw RuntimeException("unsupported ViewModel type: $modelClass")
        }
    }

    /*
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val provider = providers[modelClass]
        return provider?.get() as? T
            ?: throw RuntimeException("unsupported ViewModel type: $modelClass")
    }
     */
}
