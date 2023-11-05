package com.paawk4.hammertestapp.presentation.ui_items

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.paawk4.hammertestapp.presentation.theme.AccentColor
import com.paawk4.hammertestapp.presentation.theme.BgBottomBarColor
import com.paawk4.hammertestapp.presentation.utils.NavBarItems

@Composable
fun BottomNavBar(navController: NavHostController) {
    BottomNavigation(
        backgroundColor = BgBottomBarColor,
        contentColor = AccentColor
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        NavBarItems.BarItems.forEach { navItem ->
            BottomNavigationItem(
                selected = currentRoute == navItem.route,
                onClick = { },
                icon = {
                    Icon(
                        painter = painterResource(id = navItem.image),
                        contentDescription = navItem.title
                    )
                },
                label = {
                    Text(text = navItem.title)
                },
                alwaysShowLabel = false
            )
        }
    }
}