package io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.selectcontact.fragments

import androidx.lifecycle.Observer
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.selectcontact.SelectContactFragment
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.selectcontact.viewmodels.SelectFavoriteContactViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteContactFragment : SelectContactFragment() {

    private val viewModel by viewModel<SelectFavoriteContactViewModel>()

    override fun configureViewModelObservers() {
        configureFavoriteContactsObserver()
    }

    private fun configureFavoriteContactsObserver() {
        viewModel.favoriteContacts.observe(viewLifecycleOwner, Observer {
            setContactAdapterData(it)
        })
    }

    override fun requestData() {
        viewModel.loadFavoriteContacts()
    }


}