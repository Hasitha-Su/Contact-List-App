package com.hasitha.contactlistapp.ui.addContact

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hasitha.contactlistapp.data.local.LocalDataSource
import com.hasitha.contactlistapp.model.Contact

class AddContactViewModel() : ViewModel() {

    private val dataSource = LocalDataSource
    val contactName = MutableLiveData<String>()
    val contactNumber = MutableLiveData<String>()

    fun addContact(): Boolean {

        val name = contactName.value ?: ""
        val number = contactNumber.value ?: ""

        if (name.isNotEmpty() && number.isNotEmpty()) {
            val newContact = Contact(0, name, number)
            dataSource.addContact(newContact)

            contactName.value = ""
            contactNumber.value = ""

            return true
        }
        return false
    }
}