package com.hasitha.constactlistapp.constactlistapp.ui.contactList

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import com.hasitha.contactlistapp.ui.contactList.ContactListAdapter
import com.hasitha.contactlistapp.model.Contact
import org.robolectric.annotation.Config

/**
 * Unit tests for [ContactListAdapter].
 * This test class checks if the adapter correctly handles data.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class ContactListAdapterTest {

    private val contacts = listOf(
        Contact(1, "John", "123"),
        Contact(2, "Jane", "456")
    )
    private val adapter = ContactListAdapter(contacts)

    @Test
    fun getItemCount_ReturnsCorrectSize() {
        assertEquals(2, adapter.itemCount)
    }
}

