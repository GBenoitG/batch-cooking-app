package fr.bendev.batchcookingapp.pages.cookbook

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.bendev.batchcookingapp.R
import fr.bendev.batchcookingapp.base.BaseViewModelFactory
import fr.bendev.batchcookingapp.components.CookbookEntryCard

@Composable
fun CookbookScreen(
    viewModel: CookbookViewModel = viewModel(factory = BaseViewModelFactory {
        CookbookViewModel()
    })
) {
    val uiState: CookBookUIState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = dimensionResource(id = R.dimen.size_medium)),
        contentAlignment = Alignment.Center
    ) {

        LazyColumn {
            itemsIndexed(uiState.entries) { index, item ->
                CookbookEntryCard(entry = item, modifier = Modifier)
                if (index != uiState.entries.lastIndex) {
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.size_small)))
                }
            }
        }
    }
}