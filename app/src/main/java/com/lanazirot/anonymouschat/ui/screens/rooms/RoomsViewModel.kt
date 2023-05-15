package com.lanazirot.anonymouschat.ui.screens.rooms

import android.util.Log
import androidx.lifecycle.ViewModel
import com.lanazirot.anonymouschat.domain.models.Response
import com.lanazirot.anonymouschat.domain.services.interfaces.IStreamService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RoomsViewModel @Inject constructor (
    private val streamService: IStreamService,
): ViewModel() {
    fun connectUser() {
        val userResponse = streamService.getAnonymousUser("alan.ssuc2311@gmail.com")

        if(userResponse is Response.Success) {
            val user = userResponse.data

            if(user != null) {
                val connectionResponse = streamService.connectUser(user)

                if(connectionResponse is Response.Success) {
                    Log.d("StreamService", "User connected")
                } else {
                    Log.d("StreamService", "User not connected")
                }
            }
        }
    }
}