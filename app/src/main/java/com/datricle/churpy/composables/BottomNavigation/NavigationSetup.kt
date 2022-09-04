package com.datricle.churpy.composables.BottomNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.datricle.churpy.screens.ForYouScreen
import com.datricle.churpy.screens.MeScreen
import com.datricle.churpy.screens.MusicScreen

@Composable
fun NavigationSetup(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItems.Music.route) {
        composable(BottomNavItems.Music.route) {
            MusicScreen()
        }
        composable(BottomNavItems.ForYou.route) {
            ForYouScreen()
            //ForYouScreen(navController)
        }
        composable(Screen.Me.route) {
            MeScreen()
        }
    }
}