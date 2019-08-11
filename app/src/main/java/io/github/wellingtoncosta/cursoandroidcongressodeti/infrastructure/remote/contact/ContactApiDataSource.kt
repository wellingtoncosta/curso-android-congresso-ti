package io.github.wellingtoncosta.cursoandroidcongressodeti.infrastructure.remote.contact

import io.github.wellingtoncosta.cursoandroidcongressodeti.infrastructure.remote.contact.responses.ContactResponse

interface ContactApiDataSource {

    fun getAllContacts(): List<ContactResponse>

    fun getContactById(contactId: Int): ContactResponse?


}