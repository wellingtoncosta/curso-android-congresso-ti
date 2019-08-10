package io.github.wellingtoncosta.cursoandroidcongressodeti.domain.model

data class Contact(
    val id: Int,
    val name: String,
    val email: String,
    val phoneNumber: String,
    val favoriteId: Int? = null
)