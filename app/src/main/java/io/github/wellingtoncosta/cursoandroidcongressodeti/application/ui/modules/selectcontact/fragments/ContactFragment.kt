package io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.selectcontact.fragments

import androidx.lifecycle.Observer
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.selectcontact.SelectContactFragment
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.selectcontact.viewmodels.SelectContactViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContactFragment : SelectContactFragment() {

    private val viewModel by viewModel<SelectContactViewModel>()

    override fun configureViewModelObservers() {
        configureContactsObserver()
    }

    private fun configureContactsObserver() {
        viewModel.contacts.observe(viewLifecycleOwner, Observer {
            setContactAdapterData(it)
        })
    }

    override fun requestData() {
        viewModel.loadContacts()
    }


}