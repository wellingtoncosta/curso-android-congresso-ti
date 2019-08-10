package io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network.entity

import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.entity.Contato

/*
{
    "id":1, // int
    "name":"Fulano", // string
    "email":"fulano@email.com", // string
    "phone":"+1 77665544" // string
}
 */

data class ContatoResponse(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String
)

fun ContatoResponse.toDomain(): Contato {
    return Contato(
        id = this.id,
        nome = this.name,
        email = this.email,
        telefone = this.phone
    )
}