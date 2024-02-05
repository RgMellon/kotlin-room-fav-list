package com.example.login_list.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.login_list.RoutesLoginList
import com.example.login_list.navigation.*

@Composable
fun LoginListNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = RoutesLoginList.HomeGraph.route,
        modifier = modifier
    ) {
        loginGraph(navController)
        homeGraph(navController);
        splashGraph(navController)

    }
}


//todo entender melhor depois esse item aqui
fun NavHostController.navigateTo(rota: String) = this.navigate(rota) {
    popUpTo(this@navigateTo.graph.findStartDestination().id) {
        saveState = true
    }
    launchSingleTop = true
    restoreState = true
}