package com.hasitha.contactlistapp.ui.contactInfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hasitha.contactlistapp.model.Contact

class ContactInfoViewModel : ViewModel() {

    private val _contact = MutableLiveData<Contact>()
    val contact: LiveData<Contact> = _contact

    fun setContact(contact: Contact) {
        _contact.value = contact
    }
}
