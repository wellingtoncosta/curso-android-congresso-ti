package io.github.wellingtoncosta.cursoandroidcongressodeti.services.remote.contact

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.gson.responseObject
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.exceptions.runtimeexception.NetworkException
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.remote.contact.responses.ContactResponse

class ContactFuelApiDataSource : ContactApiDataSource {

    override fun getAllContacts() = Fuel.get("/contacts")
        .responseObject<List<ContactResponse>>().let {
            when (it.second.statusCode) {
                200, 304 -> it.third.get()
                else -> throw NetworkException()
            }
        }

    override fun getContactById(contactId: Int) = Fuel.get("/contacts/$contactId")
        .responseObject<ContactResponse>().let {
            when (it.second.statusCode) {
                200, 304 -> it.third.get()
                404 -> null
                else -> throw NetworkException()
            }
        }


}