package io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.main.selectcontact.fragments

import androidx.lifecycle.Observer
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.main.selectcontact.SelectContactFragment
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.main.selectcontact.viewmodels.SelectFavoriteContactViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteContactFragment : SelectContactFragment() {

    private val viewModel by viewModel<SelectFavoriteContactViewModel>()

    override fun configureViewModelObservers() {
        configureFavoriteContactsObserver()

        configureLoadingObserver()

        configureErrorObserver()
    }

    private fun configureFavoriteContactsObserver() {
        viewModel.favoriteContacts.observe(viewLifecycleOwner, Observer {
            setContactAdapterData(it)
        })
    }

    private fun configureLoadingObserver() {
        viewModel.loading.observe(viewLifecycleOwner, Observer { isLoading ->
            if (isLoading) {
                showLoading()
            } else {
                hideLoading()
            }
        })
    }

    private fun configureErrorObserver() {
        viewModel.error.observe(viewLifecycleOwner, Observer {
            showErrorMessage(it.message)
        })
    }

    override fun requestData() {
        viewModel.loadFavoriteContacts()
    }


}