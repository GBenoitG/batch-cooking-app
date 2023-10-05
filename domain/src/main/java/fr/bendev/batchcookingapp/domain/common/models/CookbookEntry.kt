package fr.bendev.batchcookingapp.domain.common.models

data class CookbookEntry(
    val id: String,
    val title: String,
    val ingredients: List<String>,
    val description: String,
    val tags: List<String>,
    val recipeUrl: String?,
    val imageUrl: String?
)