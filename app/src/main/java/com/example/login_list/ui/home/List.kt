package com.example.login_list.ui.home

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.login_list.ui.LoginListNavHost
import com.example.login_list.ui.theme.LoginlistTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class List: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        
        setContent {
            LoginlistTheme {
                val rememberNavController = rememberNavController()
                
                LoginListNavHost(navController = rememberNavController)
                
            }
        }
    }
}