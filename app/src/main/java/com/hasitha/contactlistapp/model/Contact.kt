package com.hasitha.contactlistapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    val image: Int,
    val name: String,
    val contactNumber: String
) : Parcelable