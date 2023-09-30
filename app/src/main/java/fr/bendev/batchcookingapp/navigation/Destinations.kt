package fr.bendev.batchcookingapp.navigation

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import fr.bendev.batchcookingapp.R

interface Destinations {
    val route: String
}

interface BottomNavigationDest : Destinations {
    @get:StringRes
    val labelId: Int

    @get:Composable
    val icon: Painter
}

object Cookbook : BottomNavigationDest {
    override val route: String
        get() = "cookbook"
    override val labelId: Int
        get() = R.string.bottom_navigation_bar_label_cookbook
    override val icon: Painter
        @Composable
        get() = painterResource(id = R.drawable.ic_cookbook)
}

object ToCook : BottomNavigationDest {
    override val route: String
        get() = "tocook"
    override val labelId: Int
        get() = R.string.bottom_navigation_bar_label_tocook
    override val icon: Painter
        @Composable
        get() = painterResource(id = R.drawable.ic_cooking_pot)
}

object Settings : BottomNavigationDest {
    override val route: String
        get() = "settings"
    override val labelId: Int
        get() = R.string.bottom_navigation_bar_label_settings
    override val icon: Painter
        @Composable
        get() = painterResource(id = R.drawable.ic_settings)
}

val bottomNavigationDestList = listOf(Cookbook, ToCook, Settings)