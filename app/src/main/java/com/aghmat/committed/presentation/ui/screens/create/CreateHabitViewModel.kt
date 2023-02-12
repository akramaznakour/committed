package com.aghmat.committed.presentation.ui.screens.create

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aghmat.committed.common.Resource
import com.aghmat.committed.domain.usecase.CreateHabit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CreateHabitViewModel @Inject constructor(
    private val createHabit: CreateHabit,
) : ViewModel() {

    private val _state = MutableStateFlow(CreateHabitScreenState())
    val state: StateFlow<CreateHabitScreenState> = _state

    @RequiresApi(Build.VERSION_CODES.O)
    fun createHabit(habitName: String, regularityTypeWithStatuses: List<RegularityTypeWithStatus>) {

        createHabit(
            habitName,
            regularityTypeWithStatuses.filter { it.selected }
                .map { it.regularityType }).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.emit(
                        CreateHabitScreenState(
                            error = result.message ?: "An unexpected error occurred"
                        )
                    )
                }
                is Resource.Loading -> {
                    _state.emit(CreateHabitScreenState(isLoading = true))
                }
                is Resource.Success -> {
                    result.data?.let { CreateHabitScreenState(createdHabit = it) }?.let {
                        _state.emit(it)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}
