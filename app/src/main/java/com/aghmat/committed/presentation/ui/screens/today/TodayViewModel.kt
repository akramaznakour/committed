package com.aghmat.committed.presentation.ui.screens.today

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aghmat.committed.common.Resource
import com.aghmat.committed.domain.usecase.GetTodayHabitsWithRegularityAndRecords
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TodayViewModel @Inject constructor(
    private val getTodayHabitsWithRegularityAndRecords: GetTodayHabitsWithRegularityAndRecords
) : ViewModel() {

    private val _state = MutableStateFlow(TodayScreenState())
    val state: StateFlow<TodayScreenState> = _state

    @RequiresApi(Build.VERSION_CODES.O)
    fun getAccount() {
        getTodayHabitsWithRegularityAndRecords().onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.emit(
                        TodayScreenState(
                            error = result.message ?: "An unexpected error occured"
                        )
                    )
                }
                is Resource.Loading -> {
                    _state.emit(TodayScreenState(isLoading = true))
                }
                is Resource.Success -> {
                    result.data?.let { TodayScreenState(todayHabitsWithRegularityAndRecords = it) }?.let {
                        _state.emit(it)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}
