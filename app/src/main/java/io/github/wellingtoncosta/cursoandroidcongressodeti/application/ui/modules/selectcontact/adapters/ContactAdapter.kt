package io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.selectcontact.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.github.wellingtoncosta.cursoandroidcongressodeti.R
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.components.contactcardview.domain.dtos.ContactDto
import io.github.wellingtoncosta.cursoandroidcongressodeti.databinding.ContactItemBinding

class ContactAdapter(private val data: List<*>) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

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
        return data.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.setContact(data[position].toString())
    }

    inner class ContactViewHolder(private val itemBinding: ContactItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun setContact(contact: String) {
            itemBinding.contactItemCardView.setContactDto(ContactDto("Eric C. Leão", "ericcleao@gmail.com", "(82)99999-9999"))
        }


    }


}