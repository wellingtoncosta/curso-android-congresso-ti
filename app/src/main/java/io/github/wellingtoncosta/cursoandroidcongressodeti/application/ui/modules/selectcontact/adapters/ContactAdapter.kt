package io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.selectcontact.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.github.wellingtoncosta.cursoandroidcongressodeti.R
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.components.contactcardview.domain.dtos.toDto
import io.github.wellingtoncosta.cursoandroidcongressodeti.databinding.ContactItemBinding
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.models.contact.Contact

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private var mData: List<Contact>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemBinding = DataBindingUtil.inflate<ContactItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.contact_item,
            parent,
            false
        )

        return ContactViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return mData?.size ?: 0
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = mData?.get(position)
        contact?.let { holder.setContact(it) }
    }

    fun addData(data: List<Contact>) {
        mData = data
        notifyDataSetChanged()
    }

    inner class ContactViewHolder(private val itemBinding: ContactItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun setContact(contact: Contact) {
            itemBinding.contactItemCardView.setContactDto(contact.toDto())
        }


    }


}