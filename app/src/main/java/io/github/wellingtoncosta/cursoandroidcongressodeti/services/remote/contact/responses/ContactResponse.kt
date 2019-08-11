package io.github.wellingtoncosta.cursoandroidcongressodeti.services.remote.contact.responses

import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.models.contact.Contact
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.local.contact.entity.ContactEntity

data class ContactResponse(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String
)


fun ContactResponse.toEntity(): ContactEntity {
    return ContactEntity(
        id = this.id,
        name = this.name,
        email = this.email,
        phoneNumber = this.phone
    )
}

fun ContactResponse.toModel(): Contact {
    return Contact(
        id = this.id,
        name = this.name,
        email = this.email,
        phoneNumber = this.phone
    )
}