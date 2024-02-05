package com.example.login_list.ui.screens.projects

import com.example.login_list.data.Project

data class ProjectUiState(
    val projects: List<Project> = listOf(
        Project(
            title = "Teste",
            description = "teste desc",
            image = "https://images.pexels.com/photos/3922294/pexels-photo-3922294.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        Project(
            title = "Teste2",
            description = "teste desc2",
            image = "https://images.pexels.com/photos/3922294/pexels-photo-3922294.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        Project(
            title = "Teste3",
            description = "teste desc3",
            image = "https://images.pexels.com/photos/3922294/pexels-photo-3922294.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        )
    )
)