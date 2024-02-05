package com.example.login_list.navigation

import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.login_list.RoutesLoginList

fun NavGraphBuilder.splashGraph(
    navController: NavHostController
) {
    composable(
        route = RoutesLoginList.SplashScreen.route
    ) {
        Text(text = "SPLASHHHHH")
    }
}