package com.example.login_list

sealed class RoutesLoginList(val route: String)  {
    object SplashScreen : RoutesLoginList("splashScreen")
    object LoginGraph : RoutesLoginList("loginGraph")
    object HomeGraph : RoutesLoginList("homeGraph")

    object List : RoutesLoginList("list")
    object Login : RoutesLoginList("login")
    object Register : RoutesLoginList("register")
    object FavList : RoutesLoginList("favList")

}