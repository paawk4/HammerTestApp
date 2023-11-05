package com.paawk4.hammertestapp.presentation.utils

import com.paawk4.hammertestapp.R
import com.paawk4.hammertestapp.domain.models.NavBarItem

object NavBarItems {
    val BarItems = listOf(
        NavBarItem(
            "Меню",
            R.drawable.ic_menu,
            "menu"
        ),
        NavBarItem(
            "Профиль",
            R.drawable.ic_profile,
            "profile"
        ),
        NavBarItem(
            "Корзина",
            R.drawable.ic_cart,
            "cart"
        )
    )
}