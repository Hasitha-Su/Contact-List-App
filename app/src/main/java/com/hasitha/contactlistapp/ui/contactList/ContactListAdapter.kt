package com.hasitha.contactlistapp.ui.contactList

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hasitha.constactlistapp.R
import com.hasitha.contactlistapp.model.Contact

class ContactListAdapter(private val mList: List<Contact>) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var filteredList: MutableList<Contact> = mList.toMutableList()

    @SuppressLint("NotifyDataSetChanged")
    fun filterByName(query: String?) {
        filteredList.clear()
        if (query.isNullOrEmpty()) {
            filteredList.addAll(mList)
        } else {
            for (contact in mList) {
                if (contact.name.contains(query, ignoreCase = true)) {
                    filteredList.add(contact)
                }
            }
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_contact_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = filteredList[position]

        holder.imageView.setImageResource(itemsViewModel.image)
        holder.textView.text = itemsViewModel.name

        holder.itemView.setOnClickListener {
            listener?.onItemClick(position)

        }
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.my_image)
        val textView: TextView = itemView.findViewById(R.id.my_text)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}