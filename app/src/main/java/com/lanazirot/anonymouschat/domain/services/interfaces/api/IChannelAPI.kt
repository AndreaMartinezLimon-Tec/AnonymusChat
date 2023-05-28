package com.lanazirot.anonymouschat.domain.services.interfaces.api

import com.lanazirot.anonymouschat.domain.constants.APIConstants
import com.lanazirot.anonymouschat.domain.models.api.AddMemberToChannelDTO
import com.lanazirot.anonymouschat.domain.models.api.CreateChannelDTO
import com.lanazirot.anonymouschat.domain.models.api.channel.CreateChannelResponseDTO
import com.lanazirot.anonymouschat.domain.models.api.location.UserCoordinatesDTO
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface IChannelAPI {
    @POST("channel/")
    @Headers("X-API-Key: ${APIConstants.API_KEY}")
    suspend fun createChannel(@Body channelDTO: CreateChannelDTO): CreateChannelResponseDTO

    @POST("channel/add-member-to-channel")
    @Headers("X-API-Key: ${APIConstants.API_KEY}")
    suspend fun addMemberToChannel(@Body channelDTO: AddMemberToChannelDTO): AddMemberToChannelDTO

    @DELETE("channel/")
    @Headers("X-API-Key: ${APIConstants.API_KEY}")
    suspend fun deleteChannel(@Body channelID: String): Boolean

    @POST("channel/check-if-user-still-in-the-room")
    @Headers("X-API-Key: ${APIConstants.API_KEY}")
    suspend fun checkIfUserStillInTheRoomByItsCurrentLocation(@Query("ChannelID") channelID: String, @Body userCoordinatesDTO: UserCoordinatesDTO): Boolean
}