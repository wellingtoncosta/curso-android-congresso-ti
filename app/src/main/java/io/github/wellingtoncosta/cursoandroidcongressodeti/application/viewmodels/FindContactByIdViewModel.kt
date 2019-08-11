package io.github.wellingtoncosta.cursoandroidcongressodeti.application.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.extensions.executors.doInBackground
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.models.contact.Contact
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.repositories.contact.ContactRepository

class FindContactByIdViewModel(private val repository: ContactRepository) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    private val _contact = MutableLiveData<Contact>()
    private val _error   = MutableLiveData<Throwable>()

    val loading: LiveData<Boolean> get() = _loading
    val contact: LiveData<Contact> get() = _contact
    val error: LiveData<Throwable> get() = _error

    fun loadContact(contactId: Int) {
        doInBackground {
            try {
                _loading.postValue(true)

                _contact.postValue(repository.getContactById(contactId))
            } catch (e: Throwable) {
                _error.postValue(e)
            } finally {
                _loading.postValue(false)
            }
        }
    }


}