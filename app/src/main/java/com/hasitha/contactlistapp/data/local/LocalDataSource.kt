package com.hasitha.contactlistapp.data.local

import com.hasitha.constactlistapp.R
import com.hasitha.contactlistapp.model.Contact

object  LocalDataSource {

    private val contacts = mutableListOf(
            Contact(R.drawable.usericon, "Jane Doe", "+1234567890"),
            Contact(R.drawable.usericon, "John Smith", "+0987654321"),
            Contact(R.drawable.usericon, "Emma Johnson", "+1234876509"),
            Contact(R.drawable.usericon, "Oliver Williams", "+0987634598"),
            Contact(R.drawable.usericon, "Sophia Brown", "+1234509876"),
            Contact(R.drawable.usericon, "Mia Jones", "+0987123456"),
            Contact(R.drawable.usericon, "Liam Davis", "+1234765980"),
            Contact(R.drawable.usericon, "Noah Wilson", "+0987901234"),
            Contact(R.drawable.usericon, "Lucas Taylor", "+1234123987"),
            Contact(R.drawable.usericon, "Ava Lee", "+0987234567"),
            Contact(R.drawable.usericon, "Isabella Harris", "+1234456789"),
            Contact(R.drawable.usericon, "Ethan Clark", "+0987345612"),
            Contact(R.drawable.usericon, "Aiden Thomas", "+1234561234"),
            Contact(R.drawable.usericon, "Isabelle Moore", "+0987456123"),
            Contact(R.drawable.usericon, "Ella Martin", "+1234678912"),
            Contact(R.drawable.usericon, "Charlotte Thompson", "+0987563412"),
            Contact(R.drawable.usericon, "Benjamin White", "+1234789561"),
            Contact(R.drawable.usericon, "Daniel Jackson", "+0987674521"),
            Contact(R.drawable.usericon, "Samuel Lewis", "+1234890123"),
            Contact(R.drawable.usericon, "Zoe Robinson", "+0987789345")
        )

    fun getContacts(): List<Contact> {
        return contacts
    }

    fun addContact(contact: Contact) {
        contacts.add(contact)
    }

    fun clearContacts() {
        contacts.clear()
    }
}