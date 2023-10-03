package fr.bendev.batchcookingapp.framework.mappers

import fr.bendev.batchcookingapp.domain.common.models.CookbookEntry
import fr.bendev.batchcookingapp.framework.database.entities.CookbookEntryDB

/**
 * API -> DOMAIN
 */


/**
 * DOMAIN -> DATABASE
 */
fun CookbookEntry.fromDomainToDB(): CookbookEntryDB = CookbookEntryDB(
    id = id,
    title = title,
    ingredients = ingredients,
    description = description,
    tags = tags,
    recipeUrl = recipeUrl,
    imageUrl = imageUrl,
)

fun List<CookbookEntry>.fromDomainToDB(): List<CookbookEntryDB> = map { it.fromDomainToDB() }

/**
 * DATABASE -> DOMAIN
 */
fun CookbookEntryDB.fromDBtoDomain(): CookbookEntry = CookbookEntry(
    id = id,
    title = title,
    ingredients = ingredients,
    description = description,
    tags = tags,
    recipeUrl = recipeUrl,
    imageUrl = imageUrl,
)

fun List<CookbookEntryDB>.fromDBtoDomain(): List<CookbookEntry> = map { it.fromDBtoDomain() }