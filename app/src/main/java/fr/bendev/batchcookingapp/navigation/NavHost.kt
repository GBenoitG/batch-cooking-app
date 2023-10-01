package fr.bendev.batchcookingapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import fr.bendev.batchcookingapp.pages.cookbook.CookbookScreen
import fr.bendev.batchcookingapp.pages.settings.SettingsScreen
import fr.bendev.batchcookingapp.pages.tocook.ToCookScreen
import timber.log.Timber

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Cookbook.route,
        modifier = modifier
    ) {
        composable(route = Cookbook.route) {
            Timber.d("Nav to Cookbook")
            CookbookScreen()
        }

        composable(route = ToCook.route) {
            Timber.d("Nav to ToCook")
            ToCookScreen()
        }

        composable(route = Settings.route) {
            Timber.d("Nav to Settings")
            SettingsScreen()
        }
    }
}