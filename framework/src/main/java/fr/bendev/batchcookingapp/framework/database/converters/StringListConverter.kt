package fr.bendev.batchcookingapp.framework.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import org.json.JSONArray

class StringListConverter {

    @TypeConverter
    fun List<String>.toDB(): String = JSONArray(this).toString()

    @TypeConverter
    fun String.fromDB(): List<String> =
        Gson().fromJson(this, Array<String>::class.java).asList()

}