@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composelearning.Presentation.contactUs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.composelearning.Data.Dimen.BigTextSize1
import com.example.composelearning.Data.Dimen.MediumPadding1
import com.example.composelearning.Data.Dimen.MediumTextSize1
import com.example.composelearning.Data.Dimen.SmallBoxSize
import com.example.composelearning.Data.Dimen.SmallPadding1
import com.example.composelearning.Presentation.components.AppBar
import com.example.composelearning.Presentation.components.CustomTextInput
import com.example.composelearning.Presentation.components.SocialButton
import com.example.composelearning.R

@ExperimentalMaterial3Api
@Composable
fun ContactUs(
    navController: NavController
) {
    val viewModel: ContactUsViewModel = viewModel()

    Scaffold(
        topBar = {
            AppBar(
                onNavigationIconClick = { navController.navigateUp() },
                stringResource(id = R.string.contact),
                if (LocalLayoutDirection.current == LayoutDirection.Ltr) Icons.Default.ArrowBack else Icons.Default.ArrowForward
            )
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(it))
            Column(
                modifier = Modifier
                    .padding(SmallPadding1)
                    .background(
                        color = colorResource(id = R.color.blackish),
                        shape = RoundedCornerShape(SmallBoxSize)
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .padding(SmallPadding1),
                    text = stringResource(id = R.string.leave_details),
                    style = TextStyle(
                        color = colorResource(id = R.color.white),
                        fontWeight = FontWeight.Bold,
                        fontSize = MediumTextSize1
                    ),
                )
                CustomTextInput(
                    stringResource(id = R.string.name),
                    Icons.Default.Person,
                    viewModel.nameState
                )
                CustomTextInput(
                    stringResource(id = R.string.email),
                    Icons.Default.Email,
                    viewModel.emailState
                )
                CustomTextInput(
                    stringResource(id = R.string.message),
                    Icons.Default.Send,
                    viewModel.messageState
                )
                Button(
                    onClick = {},
                ) {
                    Text(text = stringResource(id = R.string.send))
                }
                Spacer(modifier = Modifier.padding(SmallPadding1))
            }
            Spacer(modifier = Modifier.padding(MediumPadding1))
            Text(
                text = stringResource(id = R.string.or_contact_us_with),
                style = TextStyle(
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.Bold,
                    fontSize = BigTextSize1
                ),
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize()
                    .padding(SmallPadding1),
                horizontalArrangement = Arrangement.SpaceAround,

                ) {
                SocialButton(
                    stringResource(id = R.string.facebook),
                    painterResource(id = R.drawable.facebook_logo)
                ) {}
                SocialButton(
                    stringResource(id = R.string.instagram),
                    painterResource(id = R.drawable.instagram_logo)
                ) {}
                SocialButton(
                    stringResource(id = R.string.whatsapp),
                    painterResource(id = R.drawable.whatsapp_logo)
                ) {}
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactUsPagePreview() {
}