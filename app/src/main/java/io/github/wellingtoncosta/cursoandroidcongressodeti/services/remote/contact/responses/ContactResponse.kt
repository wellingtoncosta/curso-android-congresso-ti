package io.github.wellingtoncosta.cursoandroidcongressodeti.services.remote.contact.responses

import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.models.contact.Contact

data class ContactResponse(
    val id: Int,
    val name: String,
    val email: String,
    val phoneNumber: String
) {

    fun ContactResponse.toEntity(): Contact {
        return Contact(
            id = this.id,
            name = this.name,
            email = this.email,
            phoneNumber = this.phoneNumber
        )
    }


}