package fr.bendev.batchcookingapp.framework.network.service


/**
 * DESCRIPTION: Interface of the functions associated with each API call for an object
 * Uses the Retrofit library
 * FILE NAMING CONVENTION: {OBJECT}Service

    internal interface SampleService {

        @POST("route")
        suspend fun postAllSamples(@Body body: List<ApiSample>): Response<ResponseBody>

        @GET("route")
        suspend fun fetchSample(): Response<ApiSample>
    }

 */