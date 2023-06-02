package com.lanazirot.anonymouschat

import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.lifecycle.viewModelScope
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.lanazirot.anonymouschat.ui.providers.AppProvider
import com.lanazirot.anonymouschat.ui.providers.GlobalProvider
import com.lanazirot.anonymouschat.ui.screens.login.LoginScreen
import com.lanazirot.anonymouschat.ui.screens.login.LoginViewModel
import com.lanazirot.anonymouschat.ui.theme.AnonymousChatTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters


@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class LoginTest {
    @get:Rule(order = 1)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun test_iniciar_sesion_correo_formato_incorrecto() {
        hiltRule.inject()
        composeTestRule.activity.setContent{
            val navController = rememberNavController()
            val gp = AppProvider(navController = navController)

            AnonymousChatTheme {
                CompositionLocalProvider(
                    GlobalProvider provides gp
                ) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color.Black
                    ) {
                        LoginScreen()

                    }
                }
            }
        }
        val loginViewModel = composeTestRule.activity.viewModels<LoginViewModel>().value
        loginViewModel.viewModelScope.launch {
            delay(5000)
        }
        composeTestRule.onNodeWithTag("loginImage").assertExists()
        composeTestRule.onNodeWithText(text = "Iniciar sesión").assertExists()
        composeTestRule.onNodeWithText(text = "Correo electrónico").assertExists()
        composeTestRule.onNodeWithText(text = "Contraseña").assertExists()
        composeTestRule.onNodeWithText(text = "Correo electrónico").performTextInput("JISIDH")
        composeTestRule.onNodeWithText(text = "Contraseña").performTextInput("JISIDH")
        composeTestRule.onNodeWithText(text = "Iniciar sesión").performClick()
        composeTestRule.onNodeWithText(text = "Email invalido").assertExists()
    }

    @Test
    fun test_iniciar_sesion_contrasenia_vacia(){
        hiltRule.inject()
        composeTestRule.activity.setContent{
            val navController = rememberNavController()
            val gp = AppProvider(navController = navController)

            AnonymousChatTheme {
                CompositionLocalProvider(
                    GlobalProvider provides gp
                ) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color.Black
                    ) {
                        LoginScreen()

                    }
                }
            }
        }
        val loginViewModel = composeTestRule.activity.viewModels<LoginViewModel>().value
        loginViewModel.viewModelScope.launch {
            delay(5000)
        }
        composeTestRule.onNodeWithTag("loginImage").assertExists()
        composeTestRule.onNodeWithText(text = "Iniciar sesión").assertExists()
        composeTestRule.onNodeWithText(text = "Correo electrónico").assertExists()
        composeTestRule.onNodeWithText(text = "Contraseña").assertExists()
        composeTestRule.onNodeWithText(text = "Correo electrónico").performTextInput("JISIDH")
        composeTestRule.onNodeWithText(text = "Iniciar sesión").performClick()
        composeTestRule.onNodeWithText(text = "Contraseña vacia").assertExists()
    }

    @Test
    fun test_iniciar_sesion_correo_vacio(){
        hiltRule.inject()
        composeTestRule.activity.setContent{
            val navController = rememberNavController()
            val gp = AppProvider(navController = navController)

            AnonymousChatTheme {
                CompositionLocalProvider(
                    GlobalProvider provides gp
                ) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color.Black
                    ) {
                        LoginScreen()

                    }
                }
            }
        }
        val loginViewModel = composeTestRule.activity.viewModels<LoginViewModel>().value
        loginViewModel.viewModelScope.launch {
            delay(5000)
        }

        composeTestRule.onNodeWithTag("loginImage").assertExists()
        composeTestRule.onNodeWithText(text = "Iniciar sesión").assertExists()
        composeTestRule.onNodeWithText(text = "Correo electrónico").assertExists()
        composeTestRule.onNodeWithText(text = "Contraseña").assertExists()
        composeTestRule.onNodeWithText(text = "Contraseña").performTextInput("JISIDH")
        composeTestRule.onNodeWithText(text = "Iniciar sesión").performClick()
        composeTestRule.onNodeWithText(text = "Email vacio").assertExists()
    }
}