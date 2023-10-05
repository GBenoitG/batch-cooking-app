package fr.bendev.batchcookingapp.pages.cookbook

import fr.bendev.batchcookingapp.base.BaseUIState
import fr.bendev.batchcookingapp.domain.common.models.CookbookEntry

data class CookBookUIState(
    val entries: List<CookbookEntryUI> = emptyList()
) : BaseUIState()

data class CookbookEntryUI(
    val id: String,
    val title: String,
    val ingredients: List<String>,
    val tags: List<String>,
    val imageUrl: String?
) {
    constructor(cookbookEntry: CookbookEntry) : this(
        cookbookEntry.id,
        cookbookEntry.title,
        cookbookEntry.ingredients,
        cookbookEntry.tags,
        cookbookEntry.imageUrl
    )
}