package io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.selectcontact.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.github.wellingtoncosta.cursoandroidcongressodeti.R
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class ContactViewHolder(itemBinding: ContactItemBinding) : RecyclerView.ViewHolder(itemBinding.root)


}