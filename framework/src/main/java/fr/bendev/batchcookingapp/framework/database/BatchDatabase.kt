package fr.bendev.batchcookingapp.framework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fr.bendev.batchcookingapp.framework.database.converters.StringListConverter
import fr.bendev.batchcookingapp.framework.database.daos.CookbookEntryDao
import fr.bendev.batchcookingapp.framework.database.entities.CookbookEntryDB
import fr.bendev.batchcookingapp.framework.utils.Constants

@Database(
    entities = [
        CookbookEntryDB::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    StringListConverter::class
)
abstract class BatchDatabase : RoomDatabase() {

    /**
     * DAOs
     */
    abstract val cookbookEntryDao: CookbookEntryDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: BatchDatabase? = null

        fun getDatabase(context: Context): BatchDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BatchDatabase::class.java,
                    Constants.DB_NAME
                )
                    .addMigrations(*BatchDatabaseMigration.migrations)
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}