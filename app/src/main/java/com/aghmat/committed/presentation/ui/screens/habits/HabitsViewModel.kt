package com.aghmat.committed.presentation.ui.screens.habits


import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.aghmat.committed.common.Resource
import com.aghmat.committed.domain.model.HabitWithRegularities
import com.aghmat.committed.domain.usecase.GetHabitsWithRegularities
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HabitsViewModel @Inject constructor(
    private val getHabitsWithRegularities: GetHabitsWithRegularities
) : ViewModel() {

    private val _habits = MediatorLiveData<Resource<List<HabitWithRegularities>>>()
    val habits: LiveData<Resource<List<HabitWithRegularities>>> = _habits

    init {
        refreshHabits()
    }

    fun refreshHabits() {
        _habits.value = Resource.Loading()
        _habits.addSource(getHabitsWithRegularities().asLiveData()) { result ->
            _habits.value = result
        }
    }
}
