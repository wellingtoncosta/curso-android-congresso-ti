package io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.components.contactcardview.domain.dtos

import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.models.contact.Contact

class ContactDto(val name: String, val email: String, val phoneNumber: String)

fun Contact.toDto(): ContactDto {
    return ContactDto(
        name = this.name,
        email = this.email,
        phoneNumber = this.phoneNumber
    )
}