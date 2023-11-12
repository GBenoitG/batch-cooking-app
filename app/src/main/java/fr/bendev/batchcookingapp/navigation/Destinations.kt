package fr.bendev.batchcookingapp.navigation

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import fr.bendev.batchcookingapp.R

interface Destinations {
    val route: String
}

interface MainNavigationDest : Destinations {
    @get:StringRes
    val menuLabelId: Int

    @get:StringRes
    val pageTitleId: Int

    @get:Composable
    val icon: Painter
}

object Cookbook : MainNavigationDest {
    override val route: String
        get() = "cookbook"
    override val menuLabelId: Int
        get() = R.string.bottom_navigation_bar_label_cookbook
    override val pageTitleId: Int
        get() = R.string.cookbook_page_title
    override val icon: Painter
        @Composable
        get() = painterResource(id = R.drawable.ic_cookbook)
}

object ToCook : MainNavigationDest {
    override val route: String
        get() = "tocook"
    override val menuLabelId: Int
        get() = R.string.bottom_navigation_bar_label_tocook
    override val pageTitleId: Int
        get() = R.string.tocook_page_title
    override val icon: Painter
        @Composable
        get() = painterResource(id = R.drawable.ic_cooking_pot)
}

object Settings : MainNavigationDest {
    override val route: String
        get() = "settings"
    override val menuLabelId: Int
        get() = R.string.bottom_navigation_bar_label_settings
    override val pageTitleId: Int
        get() = R.string.settings_page_title
    override val icon: Painter
        @Composable
        get() = painterResource(id = R.drawable.ic_settings)
}

val mainNavigationDestList = listOf(Cookbook, ToCook, Settings)

fun NavDestination?.findMainNavigationDest(): MainNavigationDest =
    mainNavigationDestList.find { it.route == this?.route } ?: mainNavigationDestList.first()