package com.hasitha.contactlistapp.ui.contactList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.hasitha.constactlistapp.R
import com.hasitha.contactlistapp.data.local.LocalDataSource
import com.hasitha.contactlistapp.model.Contact

class ContactListFragment : Fragment(), ContactListAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private val localDataSource = LocalDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacts_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fab: FloatingActionButton = view.findViewById(R.id.fab)
        fab.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_contactsHome_to_newContactFragment);
        }

        recyclerView = view.findViewById(R.id.recyclerview)

        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        (activity as? AppCompatActivity)?.setSupportActionBar(toolbar)

        recyclerView.layoutManager = LinearLayoutManager(context)

        val data = localDataSource.getContacts()
        val adapter = ContactListAdapter(data)

        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter.onItemClickListener = this
        recyclerView.adapter = adapter

    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search_menu, menu)

        val searchItem = menu.findItem(R.id.actionSearch)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterRecyclerView(newText)
                return true
            }
        })
    }

    private fun filterRecyclerView(query: String?) {
        (recyclerView.adapter as? ContactListAdapter)?.filterByName(query)
    }

    override fun onItemClick(contact: Contact) {
        val action = ContactListFragmentDirections.actionContactsHomeToContactInfoFragment(contact)
        findNavController().navigate(action)
    }
}