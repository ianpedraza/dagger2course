package com.techyourchance.dagger2course.screens.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.questions.Question
import com.techyourchance.dagger2course.questions.common.DataState
import com.techyourchance.dagger2course.screens.common.viewmodels.SavedStateViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyViewModel @Inject constructor(
    private val fetchQuestionsUseCase: FetchQuestionsUseCase
) : SavedStateViewModel() {

    private lateinit var _questions: MutableLiveData<List<Question>>
    val questions: LiveData<List<Question>> get() = _questions

    override fun init(savedStateHandle: SavedStateHandle) {
        _questions = savedStateHandle.getLiveData("questions")
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
