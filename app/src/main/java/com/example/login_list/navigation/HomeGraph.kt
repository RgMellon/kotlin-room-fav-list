package com.example.login_list.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.login_list.RoutesLoginList
import com.example.login_list.ui.screens.favList.FavList
import com.example.login_list.ui.screens.favList.FavListState
import com.example.login_list.ui.screens.favList.FavListViewModel
import com.example.login_list.ui.screens.projects.ProjectUiState
import com.example.login_list.ui.screens.projects.Projects


fun NavGraphBuilder.homeGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = RoutesLoginList.List.route,
        route = RoutesLoginList.HomeGraph.route,
    ) {

        composable(route = RoutesLoginList.List.route) {

            Projects(
                state = ProjectUiState(),
                onRedirectToFavList = {
                    navController.navigate(RoutesLoginList.FavList.route)
                }
            );
        }

        composable(route = RoutesLoginList.FavList.route) {
            //aqui eu tive que executar o ViewModel para ele poder pegar do init, pois o init nunca estava sendo chamado, ai atribui isso ao state
            val viewModel = hiltViewModel<FavListViewModel>()
            val state by viewModel.uiState.collectAsState()

            FavList(
                state = state,
                onGoBack = {
                    navController.popBackStack()
                }
            );
        }

    }
}