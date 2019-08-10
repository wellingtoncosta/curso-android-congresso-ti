package io.github.wellingtoncosta.cursoandroidcongressodeti.domain.entity

data class Contato(
    val id: Int,
    val nome: String,
    val email: String,
    val telefone: String,
    val favoritoId: Int? = null
)
