package com.hasitha.contactlistapp.ui.contactInfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.hasitha.constactlistapp.databinding.FragmentContactInfoBinding

class ContactInfoFragment : Fragment() {

    private val viewModel: ContactInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentContactInfoBinding.inflate(inflater, container, false)
        //return inflater.inflate(R.layout.fragment_contact_info, container, false)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        //"contactArg" as a Parcelable Contact object via Navigation Args
        val contact = ContactInfoFragmentArgs.fromBundle(requireArguments()).contact

        viewModel.setContact(contact) // Updating LiveData

        return binding.root
    }
}