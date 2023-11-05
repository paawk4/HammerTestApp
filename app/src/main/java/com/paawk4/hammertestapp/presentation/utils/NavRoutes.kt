package com.paawk4.hammertestapp.presentation.utils

sealed class NavRoutes(val route: String) {
    data object Menu : NavRoutes("menu")
    data object Profile : NavRoutes("profile")
    data object Cart : NavRoutes("cart")
}
