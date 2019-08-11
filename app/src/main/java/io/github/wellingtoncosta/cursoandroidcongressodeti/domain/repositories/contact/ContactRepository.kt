package io.github.wellingtoncosta.cursoandroidcongressodeti.domain.repositories.contact

import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.models.contact.Contact

interface ContactRepository {

    fun getAllContacts(): List<Contact>

    fun getAllFavoriteContacts(): List<Contact>

    fun getContactById(contactId: Int): Contact?

    fun favorite(contact: Contact): Contact?


}