package fr.bendev.batchcookingapp.framework.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CookbookEntryDB(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "ingredients")
    val ingredients: List<String>,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "tags")
    val tags: List<String>,
    @ColumnInfo(name = "recipeUrl")
    val recipeUrl: String?,
    @ColumnInfo(name = "imageUrl")
    val imageUrl: String?
)
