package com.example.composelearning.Presentation.contactUs

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ContactUsViewModel : ViewModel() {

    val nameState = mutableStateOf("")
    val emailState = mutableStateOf("")
    val messageState = mutableStateOf("")

    fun sendEmail() {
        println("Sending email with Name: ${nameState.value}, Email: ${emailState.value}, Message: ${messageState.value}")
    }


}