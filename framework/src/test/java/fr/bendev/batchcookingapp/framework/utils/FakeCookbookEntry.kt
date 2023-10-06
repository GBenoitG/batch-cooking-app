package fr.bendev.batchcookingapp.framework.utils

import fr.bendev.batchcookingapp.domain.common.models.CookbookEntry

object FakeCookbookEntry {

    val entry1 = CookbookEntry(
        "id1",
        "title",
        listOf("Ingredients"),
        "description",
        listOf("tag"),
        null,
        "url"
    )

    val entry2 = CookbookEntry(
        "id2",
        "title",
        listOf("Ingredients"),
        "description",
        listOf("tag"),
        null,
        "url"
    )

    val entries = listOf(entry1, entry2)

}