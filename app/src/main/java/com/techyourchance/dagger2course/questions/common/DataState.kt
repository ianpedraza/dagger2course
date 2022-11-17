package com.techyourchance.dagger2course.questions.common

sealed class DataState<out R> {
    data class Success<out T>(val data: T) : DataState<T>()
    object Failure : DataState<Nothing>()
}
