package com.hasitha.contactlistapp.ui.addContact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hasitha.constactlistapp.databinding.FragmentNewContactBinding

class AddContactFragment : Fragment() {

    private val viewModel: AddContactViewModel by viewModels()
    private var _binding: FragmentNewContactBinding? = null
    private val binding get() = _binding ?: throw IllegalStateException("Binding is null")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Use DataBinding to inflate the layout
        _binding = FragmentNewContactBinding.inflate(inflater, container, false)

        // Bind ViewModel to layout
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.saveContactButton.setOnClickListener {
            val result = viewModel.addContact()

            if (result) {
                Toast.makeText(context, "Contact added successfully!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Please fill out all fields.", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the toolbar
        val toolbar: Toolbar = binding.addContactToolbar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setHasOptionsMenu(true)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                findNavController().navigateUp()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
