package com.scrollable_list.app.navigators

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.scrollable_list.app.routes.Routes
import com.scrollable_list.app.ui_screens.CardApp


@Composable
fun NavigatorController(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination  = "home_screen" , builder = {
        /** Home Screen route*/
        composable(Routes.HOME_SCREEN){
            CardApp(navController)
        }

    })
}