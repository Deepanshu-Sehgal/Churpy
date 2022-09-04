package com.datricle.churpy

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.datricle.churpy.composables.BottomNavigation.BottomNavigationBar
import com.datricle.churpy.composables.BottomNavigation.NavigationSetup
import com.datricle.churpy.ui.theme.ChurpyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChurpyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(bottomBar = { BottomNavigationBar(navController) }) {
                        Box(modifier = Modifier.padding(it)) {
                            NavigationSetup(navController = navController)
                        }
                    }

                }
            }
        }
    }
}

