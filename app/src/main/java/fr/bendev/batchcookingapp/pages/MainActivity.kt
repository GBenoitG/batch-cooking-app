package fr.bendev.batchcookingapp.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import fr.bendev.batchcookingapp.R
import fr.bendev.batchcookingapp.base.BaseActivity
import fr.bendev.batchcookingapp.components.CustomTopAppBar
import fr.bendev.batchcookingapp.navigation.AppNavHost
import fr.bendev.batchcookingapp.navigation.Cookbook
import fr.bendev.batchcookingapp.navigation.findMainNavigationDest
import fr.bendev.batchcookingapp.navigation.mainNavigationDestList
import fr.bendev.batchcookingapp.navigation.navigateSingleTopTo

class MainActivity : BaseActivity() {

    @Composable
    override fun SetContentView() {

        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()

        val currentMainDestination by remember {
            derivedStateOf {
                currentBackStack?.destination.findMainNavigationDest()
            }
        }

        Scaffold(
            topBar = {

                CustomTopAppBar(
                    currentMainDestination,
                    actions = {
                        when (currentMainDestination) {
                            Cookbook -> {
                                CookBookActions(
                                    onSearchAction = {},
                                    onFilterAction = {},
                                )
                            }

                            else -> {}
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar {
                    mainNavigationDestList.forEach {
                        NavigationBarItem(
                            selected = currentMainDestination == it,
                            onClick = { navController.navigateSingleTopTo(it.route) },
                            icon = {
                                Icon(
                                    painter = it.icon,
                                    contentDescription = stringResource(id = it.menuLabelId)
                                )
                            },
                            label = { Text(text = stringResource(id = it.menuLabelId)) }
                        )
                    }
                }
            }
        ) {
            AppNavHost(
                navController = navController, modifier = Modifier
                    .padding(it)
                    .background(MaterialTheme.colorScheme.surface)
            )
        }
    }

    @Composable
    private fun RowScope.CookBookActions(
        onSearchAction: () -> Unit,
        onFilterAction: () -> Unit,
    ) {
        IconButton(onClick = onSearchAction) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = stringResource(id = R.string.content_description_action_search),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        IconButton(onClick = onFilterAction) {
            Icon(
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = stringResource(id = R.string.content_description_action_filter),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}