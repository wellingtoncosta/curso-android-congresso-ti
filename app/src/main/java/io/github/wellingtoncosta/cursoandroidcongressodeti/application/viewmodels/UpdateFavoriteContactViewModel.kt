package io.github.wellingtoncosta.cursoandroidcongressodeti.application.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.extensions.executors.doInBackground
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.models.contact.Contact
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.repositories.contact.ContactRepository

class UpdateFavoriteContactViewModel(private val repository: ContactRepository) : ViewModel() {

    private val _loading  = MutableLiveData<Boolean>()
    private val _favorite = MutableLiveData<Boolean>()
    private val _error    = MutableLiveData<Throwable>()

    val loading: LiveData<Boolean> get()  = _loading
    val favorite: LiveData<Boolean> get() = _favorite
    val error: LiveData<Throwable> get()  = _error

    fun favorite(contact: Contact) {
        doInBackground {
            try {
                _loading.postValue(true)

                if (repository.favorite(contact) == null) {
                    _favorite.postValue(false)
                } else {
                    _favorite.postValue(true)
                }
            } catch (e: Throwable) {
                _error.postValue(e)
            } finally {
                _loading.postValue(false)
            }
        }
    }


}