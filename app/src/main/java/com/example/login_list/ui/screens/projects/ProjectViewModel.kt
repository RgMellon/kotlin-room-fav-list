package com.example.login_list.ui.screens.projects

import androidx.lifecycle.ViewModel
import com.example.login_list.data.Project
import com.example.login_list.database.ProjectDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProjectViewModel @Inject constructor (
    private val projectDao: ProjectDao,
): ViewModel() {
    private  val _uiState = MutableStateFlow(ProjectUiState())

    val uiState: StateFlow<ProjectUiState>
        get() = _uiState.asStateFlow()


    suspend fun favProject(project: Project) {
        projectDao.addProject(project)
    }
}