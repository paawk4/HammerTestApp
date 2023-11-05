package com.paawk4.hammertestapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.paawk4.hammertestapp.presentation.screens.MenuScreen
import com.paawk4.hammertestapp.presentation.theme.BgColor
import com.paawk4.hammertestapp.presentation.theme.HammerTestAppTheme
import com.paawk4.hammertestapp.presentation.ui_items.BottomNavBar
import com.paawk4.hammertestapp.presentation.ui_items.TopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HammerTestAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BgColor
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        topBar = {
                            TopBar()
                        },
                        bottomBar = {
                            BottomNavBar(navController = navController)
                        }
                    ) {
                        Column(
                            Modifier
                                .fillMaxSize()
                                .padding(it),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            MenuScreen()
                        }
                    }
                }
            }
        }
    }
}