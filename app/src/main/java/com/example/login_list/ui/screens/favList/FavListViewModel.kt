package com.example.login_list.ui.screens.favList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login_list.database.ProjectDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavListViewModel  @Inject  constructor(
    private val projectDao: ProjectDao,
): ViewModel(){

    private val _uiState = MutableStateFlow(FavListState())

    val uiState: StateFlow<FavListState>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            Log.i("INIT", "executado: ")
            loadFavList()
        }
    }

    private suspend fun loadFavList() {
        val list = projectDao.getAll()
        list.collect {
            _uiState.value = _uiState.value.copy(favList = it)
        }
    }
}