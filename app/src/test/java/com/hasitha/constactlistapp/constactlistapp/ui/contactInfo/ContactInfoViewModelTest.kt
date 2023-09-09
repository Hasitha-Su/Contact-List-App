package com.hasitha.constactlistapp.constactlistapp.ui.contactInfo

import com.hasitha.contactlistapp.ui.contactInfo.ContactInfoViewModel
import com.hasitha.contactlistapp.model.Contact
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Unit tests for [ContactInfoViewModel].
 * This test class ensures that the ViewModel behaves as expected.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class ContactInfoViewModelTest {

    private lateinit var viewModel: ContactInfoViewModel

    @Before
    fun setUp() {
        viewModel = ContactInfoViewModel()
    }

    @Test
    fun setContact_validContact_isSet() {
        val contact = Contact(0, "John Doe", "+1234567890")
        viewModel.setContact(contact)
        assertEquals(contact, viewModel.contact.value)
    }
}
