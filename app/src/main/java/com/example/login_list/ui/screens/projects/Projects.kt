package com.example.login_list.ui.screens.projects

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.login_list.data.Project
import com.example.login_list.ui.components.ProjectItem
import com.example.login_list.ui.theme.PurpleGrey80
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Projects(
    state: ProjectUiState = ProjectUiState(),
    modifier: Modifier = Modifier,
    onRedirectToFavList: () -> Unit = {},
    ) {

    val viewModel = hiltViewModel<ProjectViewModel>()
    val coroutineScope = rememberCoroutineScope(); //TODO pesquisar se pode ficar na screen

    Column(Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = PurpleGrey80,
                        titleContentColor = Color.Black,
                    ),
                    title = {
                        Text("Lista de projetos", fontSize = 18.sp)
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = onRedirectToFavList,
                    elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(1.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "favoritar pagina"
                    )
                }
            }
        ) { paddingValues ->
            LazyColumn(modifier.padding(paddingValues)) {
                items(state.projects) { project ->
                    ProjectItem(project, onFavProject = {projectItem->
                        coroutineScope.launch {
                            Log.i("PROJECT", "Projects: $projectItem")
                            viewModel.favProject(projectItem)
                        }
                    })
                }
            }
        }

    }
}

