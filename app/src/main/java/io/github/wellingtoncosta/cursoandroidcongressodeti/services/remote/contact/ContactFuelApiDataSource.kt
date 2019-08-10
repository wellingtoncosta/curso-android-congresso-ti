package io.github.wellingtoncosta.cursoandroidcongressodeti.services.remote.contact

import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.fuel.httpGet
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.remote.contact.responses.ContactResponse

class ContactFuelApiDataSource : ContactApiDataSource {

    override fun getAllContacts(): List<ContactResponse> {
        val (_, response, result) = "/contacts".httpGet().responseObject<List<ContactResponse>>()

        return when (response.statusCode) {
            200, 304 -> result.get()
            else -> throw Exception()
        }
    }

    override fun getContactById(contactId: Int): ContactResponse? {
        val (_, response, result) = "/contacts/$contactId".httpGet().responseObject<ContactResponse>()

        return when (response.statusCode) {
            200, 304 -> result.get()
            404 -> null
            else -> throw Exception()
        }
    }


}