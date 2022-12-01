package com.techyourchance.dagger2course.screens.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.questions.Question
import com.techyourchance.dagger2course.questions.common.DataState
import kotlinx.coroutines.launch
import javax.inject.Provider

class MyViewModel(
    private val fetchQuestionsUseCase: FetchQuestionsUseCase
) : ViewModel() {

    private val _questions = MutableLiveData<List<Question>>(emptyList())
    val questions: LiveData<List<Question>> = _questions

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
}
