package io.github.wellingtoncosta.cursoandroidcongressodeti.mock

import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.entity.Contato
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.database.entity.ContatoFavoritoEntity
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network.entity.ContatoResponse

object ContatoMocks {

    val umContatoResponse = listOf(
        ContatoResponse(id = 1, name = "Teste 1", email = "teste1@email.com", phone = "123")
    )

    val cincoContatosResponse = listOf(
        ContatoResponse(id = 1, name = "Teste 1", email = "teste2@email.com", phone = "123"),
        ContatoResponse(id = 2, name = "Teste 2", email = "teste3@email.com", phone = "234"),
        ContatoResponse(id = 3, name = "Teste 3", email = "teste3@email.com", phone = "345"),
        ContatoResponse(id = 4, name = "Teste 4", email = "teste4@email.com", phone = "456"),
        ContatoResponse(id = 5, name = "Teste 5", email = "teste5@email.com", phone = "567")
    )

    val umContatoFavoritoEntity = listOf(
        ContatoFavoritoEntity(id = 1, nome = "Teste 1", email = "teste1@email.com", telefone = "123", contatoId = 1)
    )

    val cincoContatosFavoritosEntity = listOf(
        ContatoFavoritoEntity(id = 1, nome = "Teste 1", email = "teste2@email.com", telefone = "123", contatoId = 1),
        ContatoFavoritoEntity(id = 2, nome = "Teste 2", email = "teste3@email.com", telefone = "234", contatoId = 1),
        ContatoFavoritoEntity(id = 3, nome = "Teste 3", email = "teste3@email.com", telefone = "345", contatoId = 1),
        ContatoFavoritoEntity(id = 4, nome = "Teste 4", email = "teste4@email.com", telefone = "456", contatoId = 1),
        ContatoFavoritoEntity(id = 5, nome = "Teste 5", email = "teste5@email.com", telefone = "567", contatoId = 1)
    )

    val umContato = Contato(id = 1, nome = "Teste 1", email = "teste2@email.com", telefone = "123")

}