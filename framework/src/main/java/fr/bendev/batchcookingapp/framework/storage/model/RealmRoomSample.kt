package fr.bendev.batchcookingapp.framework.storage.model


/**
 * DESCRIPTION: Data class reflecting the database version of the corresponding business object
 * FILE NAMING CONVENTION: {DatabaseFramework}{OBJECT} (i.e. RoomSample or RealmSample)
 */

//ROOM
data class RealmRoomSample (
    var id: String,
    var parameter: String
)

//REALM
/*
open class RealmRoomSample: RealmObject() (
    @PrimaryKey
    var id: String
    var parameter: String
)*/
