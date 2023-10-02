package fr.bendev.batchcookingapp.framework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.bendev.batchcookingapp.framework.database.entities.SampleEntity
import fr.bendev.batchcookingapp.framework.utils.Constants

@Database(
    entities = [
        SampleEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class BatchDatabase : RoomDatabase() {

    /**
     * DAOs
     */

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