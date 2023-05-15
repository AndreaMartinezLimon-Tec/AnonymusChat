package com.lanazirot.anonymouschat.ui.screens.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lanazirot.anonymouschat.domain.models.drawer.ScrollableScreen
import com.lanazirot.anonymouschat.R
import com.lanazirot.anonymouschat.ui.providers.GlobalProvider

//Nota: Separarlas proximamente

@Composable
fun TopBar(title: String = "", buttonIcon: ImageVector, icon : Painter, onButtonClicked: () -> Unit) {
    TopAppBar(
        title = {
            Image(
                painter = icon,
                contentDescription = "null",
                modifier = Modifier.size(25.dp)
            )
            Text(
                text = "      $title",
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(onClick = { onButtonClicked() } ) {
                Icon(buttonIcon, contentDescription = "", tint = Color.White)
            }
        },
        backgroundColor = Color.Black
    )
}

@Composable
fun Invitar() {
    val navController = GlobalProvider.current.navController

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Invitar",
            icon = painterResource(R.drawable.iinvitar),
            buttonIcon = Icons.Filled.ArrowBack,
            onButtonClicked = { navController.popBackStack() }
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Home Page content here.")
        }
    }
}

@Composable
fun Dudas() {
    val navController = GlobalProvider.current.navController

    val listItems = listOf("General", "¿Que es Anonymous Chat?", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris elementum porttitor dapibus."
        , "¿Quienes pueden enviarme mensaje?", "Praesent suscipit semper risus non aliquam. Aenean non ante eu ligula vehicula vehicula. Quisque sodales tincidunt mattis."
        , "¿Como se maneja la privacidad en  Anonymous Chat?", "Cras varius lacus ac eros vulputate vulputate. Nunc nec blandit quam, vitae convallis elit. Sed rutrum placerat justo eget rutrum."
        ,"¿Que son los nombres de usuario? ¿Como se eligen?","Cras varius lacus ac eros vulputate vulputate. Nunc nec blandit quam, vitae convallis elit. Sed rutrum placerat justo eget rutrum.")

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Dudas",
            icon = painterResource(R.drawable.idudas),
            buttonIcon = Icons.Filled.ArrowBack,
            onButtonClicked = { navController.popBackStack() }
        )
        ScrollableScreen(listItems)
    }
}

@Composable
fun Preferencias() {
    val navController = GlobalProvider.current.navController

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Preferencias",
            icon = painterResource(R.drawable.ipreferencias),
            buttonIcon = Icons.Filled.ArrowBack,
            onButtonClicked = { navController.popBackStack() }
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Home Page content here.")
        }
    }
}

@Composable
fun Politicas() {
    val navController = GlobalProvider.current.navController
    val listItems = listOf("Interpretation and Definition", "Interpretation", "The words of which the initial letter is capitalized have meanings defined under the following conditions. The following definitions shall have the same meaning regardless of whether they appear in singular or in plural."
    , "Definitions", "For the purposes of this Privacy Policy:\n" +
                "Account means a unique account created for You to access our Service or parts of our Service.\n" +
                "Affiliate means an entity that controls, is controlled by or is under common control with a party, where “control” means ownership of 50% or more of the shares, equity interest or other securities entitled to vote for election of directors or other managing authority.\n" +
                "Application refers to Anonymous Chat, the software program provided by the Company.\n" +
                "Company (referred to as either “the Company”, “We”, “Us” or “Our” in this Agreement) refers to Anonymous Chat.\n" +
                "Country refers to:  Mexico\n" +
                "Device means any device that can access the Service such as a computer, a cellphone or a digital tablet.\n" +
                "Personal Data is any information that relates to an identified or identifiable individual.\n" +
                "Service refers to the Application.\n" +
                "Service Provider means any natural or legal person who processes the data on behalf of the Company. It refers to third-party companies or individuals employed by the Company to facilitate the Service, to provide the Service on behalf of the Company, to perform services related to the Service or to assist the Company in analyzing how the Service is used.\n" +
                "Usage Data refers to data collected automatically, either generated by the use of the Service or from the Service infrastructure itself (for example, the duration of a page visit).\n" +
                "You means the individual accessing or using the Service, or the company, or other legal entity on behalf of which such individual is accessing or using the Service, as applicable.\n"
        , "Collecting and Using Your Personal Data", "Types of Data Collected", "Personal Data"
        , "While using Our Service, We may ask You to provide Us with certain personally identifiable information that can be used to contact or identify You. Personally identifiable information may include, but is not limited to:\n" +
                "Email address\n" +
                "Usage Data\n" +
                "Usage Data\n" +
                "Usage Data is collected automatically when using the Service.\n" +
                "Usage Data may include information such as Your Device's Internet Protocol address (e.g. IP address), browser type, browser version, the pages of our Service that You visit, the time and date of Your visit, the time spent on those pages, unique device identifiers and other diagnostic data.\n" +
                "When You access the Service by or through a mobile device, We may collect certain information automatically, including, but not limited to, the type of mobile device You use, Your mobile device unique ID, the IP address of Your mobile device, Your mobile operating system, the type of mobile Internet browser You use, unique device identifiers and other diagnostic data.\n" +
                "We may also collect information that Your browser sends whenever You visit our Service or when You access the Service by or through a mobile device.\n")

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Politicas",
            icon = painterResource(R.drawable.ipoliticas),
            buttonIcon = Icons.Filled.ArrowBack,
            onButtonClicked = { navController.popBackStack() }
        )
        ScrollableScreen(listItems)
    }
}

@Composable
fun Creditos() {
    val navController = GlobalProvider.current.navController

    Column(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        TopBar(
            title = "Creditos",

            icon = painterResource(R.drawable.icreditos),
            buttonIcon = Icons.Filled.ArrowBack,
            onButtonClicked = { navController.popBackStack() }
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Home Page content here.")
        }
    }
}