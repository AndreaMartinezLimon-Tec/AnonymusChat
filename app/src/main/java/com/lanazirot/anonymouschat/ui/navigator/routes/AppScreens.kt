package com.lanazirot.anonymouschat.ui.navigator.routes

sealed class AppScreens(val title: String, val route: String)  {
    object Login : AppScreens("Iniciar sesion","login")
    object Register : AppScreens("Registrarse","register")
    object Chat: AppScreens("Chat","chat")
}