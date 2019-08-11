package io.github.wellingtoncosta.cursoandroidcongressodeti.resources.repository

import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.entity.Contato
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.repository.ContatoRepository
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.database.dao.ContatoFavoritoDao
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.database.entity.toDomain
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.database.entity.toEntity
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network.ContatoApi
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network.entity.toDomain

class ContatoRepositoryImpl(
    private val api: ContatoApi,
    private val dao: ContatoFavoritoDao
) : ContatoRepository {

    override fun listarTodos() = api.listarTodos().map { it.toDomain() }

    override fun listarFavoritos() = dao.listarTodos().map { it.toDomain() }

    override fun buscarPorId(contatoId: Int) = api.buscarPorId(contatoId).let { response ->
        if(response != null) {
            val favorito = dao.buscarPorContatoId(contatoId)

            response.toDomain().copy(favoritoId = favorito?.id)
        } else {
            null
        }
    }

    override fun favoritar(contato: Contato) = dao.buscarPorContatoId(contato.id).let { favorito ->
        if(favorito == null) {
            val favoritoId = dao.inserir(contato.toEntity())

            contato.copy(favoritoId = favoritoId.toInt())
        } else {
            dao.deletar(contato.toEntity().copy(id = favorito.id))

            contato.copy(favoritoId = null)
        }
    }

}
