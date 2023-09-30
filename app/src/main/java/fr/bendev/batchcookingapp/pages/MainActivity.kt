package fr.bendev.batchcookingapp.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import fr.bendev.batchcookingapp.base.BaseActivity
import fr.bendev.batchcookingapp.navigation.AppNavHost
import fr.bendev.batchcookingapp.navigation.Cookbook
import fr.bendev.batchcookingapp.navigation.bottomNavigationDestList
import fr.bendev.batchcookingapp.navigation.navigateSingleTopTo

class MainActivity : BaseActivity() {

    @Composable
    override fun SetContentView() {

        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen =
            bottomNavigationDestList.find { it.route == currentDestination?.route } ?: Cookbook

        Column {
            AppNavHost(navController = navController, modifier = Modifier.weight(1f))
            NavigationBar {
                bottomNavigationDestList.forEach {
                    NavigationBarItem(
                        selected = currentScreen == it,
                        onClick = { navController.navigateSingleTopTo(it.route) },
                        icon = {
                            Icon(
                                painter = it.icon,
                                contentDescription = stringResource(id = it.labelId)
                            )
                        },
                        label = { Text(text = stringResource(id = it.labelId)) }
                    )
                }
            }
        }
    }
}