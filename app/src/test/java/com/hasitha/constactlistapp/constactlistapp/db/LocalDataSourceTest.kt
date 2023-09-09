package com.hasitha.constactlistapp.constactlistapp.db

import com.hasitha.contactlistapp.data.local.LocalDataSource
import com.hasitha.contactlistapp.model.Contact
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Unit tests for [LocalDataSource] class.
 */
class LocalDataSourceTest {

    @Before
    fun setUp() {
        LocalDataSource.clearContacts()
    }

    @Test
    fun addContact_addOneContact_sizeIsOne() {
        val contact = Contact(0, "John Doe", "+1234567890")
        LocalDataSource.addContact(contact)
        assertEquals(1, LocalDataSource.getContacts().size)
    }

    @Test
    fun addContact_addOneContact_retrievesSameContact() {
        val contact = Contact(0, "John Doe", "+1234567890")
        LocalDataSource.addContact(contact)
        val retrievedContact = LocalDataSource.getContacts()[0]
        assertEquals(contact, retrievedContact)
    }
}
