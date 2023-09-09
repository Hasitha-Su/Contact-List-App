package com.hasitha.constactlistapp.constactlistapp.ui.addContact

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hasitha.contactlistapp.ui.addContact.AddContactViewModel
import com.hasitha.contactlistapp.data.local.LocalDataSource
import com.hasitha.contactlistapp.model.Contact
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Unit tests for [AddContactViewModel].
 * This test class verifies the ViewModel's logic.
 */
class AddContactViewModelTest {

    @Before
    fun setUp() {
        LocalDataSource.clearContacts()
    }

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun testAddContact() {
        val viewModel = AddContactViewModel()
        viewModel.contactName.value = "John Doe"
        viewModel.contactNumber.value = "1234567890"

        val result = viewModel.addContact()
        assertTrue(result)

        val contacts = LocalDataSource.getContacts()
        assertEquals(1, contacts.size)
        assertEquals(Contact(0, "John Doe", "1234567890"), contacts[0])
    }

    @Test
    fun testAddContact_Failure() {
        val viewModel = AddContactViewModel()
        viewModel.contactName.value = ""
        viewModel.contactNumber.value = ""

        val result = viewModel.addContact()
        assertFalse(result)
    }
}

