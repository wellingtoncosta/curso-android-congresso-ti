package io.github.wellingtoncosta.cursoandroidcongressodeti.domain.repository

import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.entity.Contato

interface ContatoRepository {

    fun listarTodos(): List<Contato>

    fun listarFavoritos(): List<Contato>

    fun buscarPorId(contatoId: Int): Contato?

    fun favoritar(contato: Contato) : Contato

}
