package com.datricle.churpy.composables.BottomNavigation

//Screen.kt defines a list of the destinations in the app which includes
// bottom navigation destinations and regular destinations
sealed class Screen(val route:String){
    object Music:Screen("music")
    object ForYou:Screen("for_you")
    object Me:Screen("me")
}
