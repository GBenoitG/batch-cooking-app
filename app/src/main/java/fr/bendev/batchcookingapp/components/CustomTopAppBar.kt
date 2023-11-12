package fr.bendev.batchcookingapp.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import fr.bendev.batchcookingapp.navigation.Cookbook
import fr.bendev.batchcookingapp.navigation.MainNavigationDest
import fr.bendev.batchcookingapp.navigation.Settings
import fr.bendev.batchcookingapp.navigation.ToCook
import fr.bendev.batchcookingapp.ui.theme.BatchTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    currentDest: MainNavigationDest,
    modifier: Modifier = Modifier,
    actions: @Composable RowScope.() -> Unit = {},
) {
    when (currentDest) {
        Cookbook -> MediumTopAppBar(
            title = {
                Text(
                    text = stringResource(id = currentDest.pageTitleId),
                    style = MaterialTheme.typography.headlineMedium
                )
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(),
            actions = actions,
            modifier = modifier
        )

        ToCook -> CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(id = currentDest.pageTitleId),
                    style = MaterialTheme.typography.headlineMedium
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(),
            actions = actions,
            modifier = modifier
        )

        Settings -> CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(id = currentDest.pageTitleId),
                    style = MaterialTheme.typography.headlineMedium
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
            actions = actions,
            modifier = modifier
        )
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    BatchTheme {
        CustomTopAppBar(
            Cookbook
        )
    }
}