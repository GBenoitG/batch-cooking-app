package fr.bendev.batchcookingapp.framework.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SampleEntity(
    @PrimaryKey
    val id: String
)
