package fr.bendev.batchcookingapp.framework.extensions.mappers

import fr.bendev.batchcookingapp.domain.model.Sample
import fr.bendev.batchcookingapp.framework.network.model.ApiSample
import fr.bendev.batchcookingapp.framework.storage.model.RealmRoomSample

/**
 * DESCRIPTION: Mapper class that contains all extensions functions used for business object, api object, and database object conversion
 * FILE NAMING CONVENTION: {Object}Mapper
 */

fun Sample.toRealmSample(): RealmRoomSample {
    TODO ("Not yet implement")
}
fun RealmRoomSample.toSample(): Sample {
    TODO ("Not yet implement")
}
fun ApiSample.toRealmSample(): RealmRoomSample {
    TODO ("Not yet implement")
}