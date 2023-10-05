package fr.bendev.batchcookingapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import fr.bendev.batchcookingapp.R
import fr.bendev.batchcookingapp.pages.cookbook.CookbookEntryUI
import fr.bendev.batchcookingapp.ui.theme.BatchTheme

private const val MAX_INGREDIENTS_DISPLAYED = 2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CookbookEntryCard(
    entry: CookbookEntryUI,
    modifier: Modifier
) {
    Card(
        onClick = { /*TODO*/ },
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurfaceVariant),
        modifier = modifier
            .height(dimensionResource(id = R.dimen.card_height))
            .fillMaxWidth(),
        colors = CardDefaults.outlinedCardColors(

        )
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = entry.imageUrl,
                contentDescription = entry.title,
                placeholder = painterResource(R.drawable.ic_launcher_background),
                modifier = Modifier
                    .fillMaxHeight()
                    .width(dimensionResource(id = R.dimen.image_card_width))
                    .clip(CardDefaults.shape),
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier
                    .padding(
                        horizontal = dimensionResource(id = R.dimen.size_small),
                        vertical = dimensionResource(id = R.dimen.size_xsmall)
                    )
                    .weight(1f)
            ) {
                Text(
                    text = entry.title,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.fillMaxWidth()
                )
                entry.ingredients.take(MAX_INGREDIENTS_DISPLAYED).forEach {
                    Text(
                        text = "- $it",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Row(
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    entry.tags.forEachIndexed { index, tag ->
                        SuggestionChip(
                            onClick = { /*NOTHING*/ },
                            label = {
                                Text(text = tag, style = MaterialTheme.typography.labelMedium)
                            })
                        if (index != entry.tags.lastIndex) {
                            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.size_xsmall)))
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CookbookEntryCardPreview() {
    BatchTheme {
        CookbookEntryCard(
            entry = CookbookEntryUI(
                "ID",
                "Title",
                listOf("Ingredient1", "Ingredient2", "Ingredient3", "Ingredient4"),
                listOf("Tag1", "Tag2"),
                "https://previews.123rf.com/images/illustratiostock/illustratiostock2205/illustratiostock220501166/186521931-isolated-healthy-food-vegeteables-fruits-and-protein-vector-illustration.jpg"
            ),
            modifier = Modifier
        )
    }
}