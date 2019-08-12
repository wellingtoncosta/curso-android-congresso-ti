package io.github.wellingtoncosta.cursoandroidcongressodeti.testutil.mock

import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.entity.Contato
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.database.entity.ContatoFavoritoEntity
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network.entity.ContatoResponse

object ContatoMocks {

    val umContatoResponse = listOf(
        ContatoResponse(id = 1, name = "Contato 1", email = "contato1@email.com", phone = "123")
    )

    val cincoContatosResponse = listOf(
        ContatoResponse(id = 1, name = "Contato 1", email = "contato2@email.com", phone = "123"),
        ContatoResponse(id = 2, name = "Contato 2", email = "contato3@email.com", phone = "234"),
        ContatoResponse(id = 3, name = "Contato 3", email = "contato3@email.com", phone = "345"),
        ContatoResponse(id = 4, name = "Contato 4", email = "contato4@email.com", phone = "456"),
        ContatoResponse(id = 5, name = "Contato 5", email = "contato5@email.com", phone = "567")
    )

    val umContatoFavoritoEntity = listOf(
        ContatoFavoritoEntity(id = 1, nome = "Contato 1", email = "contato1@email.com", telefone = "123", contatoId = 1)
    )

    val cincoContatosFavoritosEntity = listOf(
        ContatoFavoritoEntity(id = 1, nome = "Contato 1", email = "contato2@email.com", telefone = "123", contatoId = 1),
        ContatoFavoritoEntity(id = 2, nome = "Contato 2", email = "contato3@email.com", telefone = "234", contatoId = 1),
        ContatoFavoritoEntity(id = 3, nome = "Contato 3", email = "contato3@email.com", telefone = "345", contatoId = 1),
        ContatoFavoritoEntity(id = 4, nome = "Contato 4", email = "contato4@email.com", telefone = "456", contatoId = 1),
        ContatoFavoritoEntity(id = 5, nome = "Contato 5", email = "contato5@email.com", telefone = "567", contatoId = 1)
    )

    val umContato = Contato(id = 1, nome = "Contato 1", email = "contato1@email.com", telefone = "123")
    
    val cincoContatos = listOf(
        Contato(id = 1, nome = "Contato 1", email = "contato1@email.com", telefone = "123"),
        Contato(id = 2, nome = "Contato 2", email = "contato2@email.com", telefone = "234"),
        Contato(id = 3, nome = "Contato 3", email = "contato3@email.com", telefone = "345"),
        Contato(id = 4, nome = "Contato 4", email = "contato4@email.com", telefone = "456"),
        Contato(id = 5, nome = "Contato 5", email = "contato5@email.com", telefone = "567")
    )

}