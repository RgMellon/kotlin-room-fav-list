package com.example.login_list.navigation




import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.login_list.RoutesLoginList
import com.example.login_list.ui.screens.login.Login

fun NavGraphBuilder.loginGraph(
    navController: NavController
) {
    navigation(
        startDestination = RoutesLoginList.Login.route, //define a rota inicial do graph
        route = RoutesLoginList.LoginGraph.route // Define a rota geral para o gráfico de navegação, indicando que este gráfico de navegação está relacionado ao login.
    ) {
        //está sendo especificada uma rota específica para a qual a navegação deve ocorrer. Neste caso, é a rota de login.
        composable(RoutesLoginList.Login.route) {
                Login();
        }


        // A logica de cadastro vai aqui, fiz apenas pra testar
        composable(RoutesLoginList.Register.route) {
            Text(text = "Registro")
        }
    }
}