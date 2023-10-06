package fr.bendev.batchcookingapp.framework

import fr.bendev.batchcookingapp.domain.common.models.CookbookEntry
import fr.bendev.batchcookingapp.framework.database.entities.CookbookEntryDB
import fr.bendev.batchcookingapp.framework.mappers.fromDBtoDomain
import fr.bendev.batchcookingapp.framework.mappers.fromDomainToDB
import org.junit.Assert
import org.junit.Test

class CookbookEntryMapperTest {

    @Test
    fun `GIVEN full CookbookEntry, WHEN mapper to DB, THEN full CookbookEntryDB`() {
        // GIVEN
        val cookbookEntry = CookbookEntry(
            "id",
            "meal",
            listOf("ingredient"),
            "Description",
            listOf("tag"),
            "url",
            "url"
        )

        // WHEN
        val cookbookEntryDB = cookbookEntry.fromDomainToDB()

        // THEN
        Assert.assertEquals(cookbookEntryDB, CookbookEntryDB(
            "id",
            "meal",
            listOf("ingredient"),
            "Description",
            listOf("tag"),
            "url",
            "url"
        ))
    }

    @Test
    fun `GIVEN full CookbookEntryDB, WHEN mapper to DB, THEN full CookbookEntry`() {
        // GIVEN
        val cookbookEntryDB = CookbookEntryDB(
            "id",
            "meal",
            listOf("ingredient"),
            "Description",
            listOf("tag"),
            "url",
            "url"
        )

        // WHEN
        val cookbookEntry = cookbookEntryDB.fromDBtoDomain()

        // THEN
        Assert.assertEquals(cookbookEntry, CookbookEntry(
            "id",
            "meal",
            listOf("ingredient"),
            "Description",
            listOf("tag"),
            "url",
            "url"
        ))
    }

}