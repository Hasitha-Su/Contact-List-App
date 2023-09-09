package com.hasitha.constactlistapp.constactlistapp.ui.addContact

import com.hasitha.contactlistapp.ui.addContact.AddContactFragment
import org.robolectric.RobolectricTestRunner
import junit.framework.TestCase.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import androidx.fragment.app.testing.launchFragmentInContainer
import com.hasitha.constactlistapp.R

/**
 * UI tests for [AddContactFragment].
 * These tests focus on UI components and their interactions.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class AddContactFragmentTest {

    @Test
    fun `should display the correct UI elements`() {
        val scenario = launchFragmentInContainer<AddContactFragment>()

        scenario.onFragment { fragment ->
            assertNotNull(fragment.view?.findViewById(R.id.saveContactButton))
        }
    }
}
