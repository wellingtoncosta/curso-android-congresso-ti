package io.github.wellingtoncosta.cursoandroidcongressodeti.resources.repository

import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.entity.Contato
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.repository.ContatoRepository
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.database.dao.ContatoFavoritoDao
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.database.entity.toDomain
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.database.entity.toEntity
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.extension.runAsync
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network.ContatoApi
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network.entity.toDomain

class ContatoRepositoryImpl(
    private val api: ContatoApi,
    private val dao: ContatoFavoritoDao
) : ContatoRepository {

    override fun listarTodos(): List<Contato> {
        return runAsync {
            api.listarTodos().map { it.toDomain() }
        }
    }

    override fun listarFavoritos(): List<Contato> {
        return runAsync {
            dao.listarTodos().map { it.toDomain() }
        }
    }

    override fun buscarPorId(contatoId: Int): Contato? {
        return runAsync {
            val response = api.buscarPorId(contatoId)

            if(response != null) {
                val favorito = dao.buscarPorContatoId(contatoId)

                response.toDomain().copy(favoritoId = favorito?.id)
            } else {
                null
            }
        }
    }

    override fun favoritar(contato: Contato): Contato {
        return runAsync {
            val favorito = dao.buscarPorContatoId(contato.id)

            if(favorito == null) {
                val favoritoId = dao.inserir(contato.toEntity())

                contato.copy(favoritoId = favoritoId.toInt())
            } else {
                dao.deletar(contato.toEntity())

                contato.copy(favoritoId = null)
            }
        }
    }

}
