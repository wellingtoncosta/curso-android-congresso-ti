package io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.selectcontact.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.extensions.executors.doInBackground
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.models.contact.Contact
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.repositories.contact.ContactRepository

class SelectContactViewModel(private val repository: ContactRepository) : ViewModel() {

    private val _loading  = MutableLiveData<Boolean>()
    private val _contacts = MutableLiveData<List<Contact>>()
    private val _error    = MutableLiveData<Throwable>()

    val loading: LiveData<Boolean> get()        = _loading
    val contacts: LiveData<List<Contact>> get() = _contacts
    val error: LiveData<Throwable> get()        = _error

    private fun loadContacts() {
        doInBackground {
            try {
                _loading.postValue(true)

                _contacts.postValue(repository.getAllContacts())
            } catch (e: Throwable) {
                _error.postValue(e)
            } finally {
                _loading.postValue(false)
            }
        }
    }


}