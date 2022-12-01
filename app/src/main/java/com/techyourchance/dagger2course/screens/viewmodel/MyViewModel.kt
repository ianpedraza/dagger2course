package com.techyourchance.dagger2course.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.questions.Question
import com.techyourchance.dagger2course.questions.common.DataState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class MyViewModel @Inject constructor(
    private val fetchQuestionsUseCase: FetchQuestionsUseCase
) : ViewModel() {

    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    val questions: StateFlow<List<Question>> = _questions

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            val result = fetchQuestionsUseCase.fetchLatestQuestion()
            if (result is DataState.Success) {
                _questions.value = result.data
            }
        }
    }

    class MyViewModelFactory @Inject constructor(
        private val myViewModelProvider: Provider<MyViewModel>
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return myViewModelProvider.get() as T
        }
    }
}
