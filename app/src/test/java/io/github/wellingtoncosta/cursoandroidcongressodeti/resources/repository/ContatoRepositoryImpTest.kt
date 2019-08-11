package io.github.wellingtoncosta.cursoandroidcongressodeti.resources.repository

import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.entity.Contato
import io.github.wellingtoncosta.cursoandroidcongressodeti.mock.ContatoMocks.cincoContatosFavoritosEntity
import io.github.wellingtoncosta.cursoandroidcongressodeti.mock.ContatoMocks.cincoContatosResponse
import io.github.wellingtoncosta.cursoandroidcongressodeti.mock.ContatoMocks.umContato
import io.github.wellingtoncosta.cursoandroidcongressodeti.mock.ContatoMocks.umContatoFavoritoEntity
import io.github.wellingtoncosta.cursoandroidcongressodeti.mock.ContatoMocks.umContatoResponse
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.database.dao.ContatoFavoritoDao
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network.ContatoApi
import io.mockk.*
import org.junit.Assert.assertTrue
import org.junit.Test

class ContatoRepositoryImpTest {

    private val api = mockk<ContatoApi>()

    private val dao = mockk<ContatoFavoritoDao>()

    private val repository = ContatoRepositoryImpl(api, dao)

    private lateinit var resultadoListagemTodos: List<Contato>

    private lateinit var resultadoListagemFavoritos: List<Contato>

    private var resultadoBuscarPorId: Contato? = null

    private var resultadoFavoritar: Contato? = null

    @Test fun`listar contatos com resultado vazio`() {

        `dado que eu tenha uma lista de contatos vazia`()

        `quando eu listar os contatos`()

        `entao eu devo receber uma lista vazia de contatos`()

    }

    @Test fun`listar contatos com um resultado`() {

        `dado que eu tenha uma lista com um contato`()

        `quando eu listar os contatos`()

        `entao eu devo receber uma lista com um contato`()

    }

    @Test fun`listar contatos com cinco resultados`() {

        `dado que eu tenha uma lista com cinco contatos`()

        `quando eu listar os contatos`()

        `entao eu devo receber uma lista com cinco contatos`()

    }

    @Test fun`listar contatos favoritos com resultado vazio`() {

        `dado que eu tenha uma lista de contatos favoritos vazia`()

        `quando eu listar os contatos favoritos`()

        `entao eu devo receber uma lista vazia de contatos favoritos`()

    }

    @Test fun`listar contatos favoritos com um resultado`() {

        `dado que eu tenha uma lista com um contato favorito`()

        `quando eu listar os contatos favoritos`()

        `entao eu devo receber uma lista com um contato favorito`()

    }

    @Test fun`listar contatos favoritos com cinco resultados`() {

        `dado que eu tenha uma lista com cinco contatos favoritos`()

        `quando eu listar os contatos favoritos`()

        `entao eu devo receber uma lista com cinco contatos favoritos`()

    }

    @Test fun `buscar contato inexistente por id`() {

        `dado que eu nao tenha um contato por id`()

        `quando eu buscar um contato pelo id`()

        `entao eu nao devo receber um contato pelo id`()

    }

    @Test fun `buscar contato existente por id que ainda nao seja favorito`() {

        `dado que eu tenha um contato nao favorito por id`()

        `quando eu buscar um contato pelo id`()

        `entao eu devo receber um contato nao favorito pelo id`()

    }

    @Test fun `buscar contato existente por id que seja favorito`() {

        `dado que eu tenha um contato favorito por id`()

        `quando eu buscar um contato pelo id`()

        `entao eu devo receber um contato favorito pelo id`()

    }

    @Test fun `favoritar um contato`() {

        `dado que eu tenha um contato ainda nao favorito`()

        `quando eu favoritar um contato`()

        `entao eu devo receber um contato marcado como favorito`()

    }

    @Test fun `desfavoritar um contato`() {

        `dado que eu tenha um contato favorito`()

        `quando eu favoritar um contato`()

        `entao eu devo receber um contato nao favorito`()

    }

    private fun `dado que eu tenha uma lista de contatos vazia`() {
        every { api.listarTodos() } returns emptyList()
    }

    private fun `dado que eu tenha uma lista com um contato`() {
        every { api.listarTodos() } returns umContatoResponse
    }

    private fun `dado que eu tenha uma lista com cinco contatos`() {
        every { api.listarTodos() } returns cincoContatosResponse
    }

    private fun `dado que eu tenha uma lista de contatos favoritos vazia`() {
        every { dao.listarTodos() } returns emptyList()
    }

    private fun `dado que eu tenha uma lista com um contato favorito`() {
        every { dao.listarTodos() } returns umContatoFavoritoEntity
    }

    private fun `dado que eu tenha uma lista com cinco contatos favoritos`() {
        every { dao.listarTodos() } returns cincoContatosFavoritosEntity
    }

    private fun `dado que eu nao tenha um contato por id`() {
        every { api.buscarPorId(any()) } returns null
    }

    private fun `dado que eu tenha um contato nao favorito por id`() {
        every { api.buscarPorId(any()) } returns umContatoResponse[0]

        every { dao.buscarPorContatoId(any()) } returns null
    }

    private fun `dado que eu tenha um contato favorito por id`() {
        every { api.buscarPorId(any()) } returns umContatoResponse[0]

        every { dao.buscarPorContatoId(any()) } returns umContatoFavoritoEntity[0]
    }

    private fun `dado que eu tenha um contato ainda nao favorito`() {
        every { dao.buscarPorContatoId(any()) } returns null

        every { dao.inserir(any()) } returns 1
    }

    private fun `dado que eu tenha um contato favorito`() {
        every { dao.buscarPorContatoId(any()) } returns umContatoFavoritoEntity[0]

        every { dao.deletar(any()) } just Runs
    }

    private fun `quando eu listar os contatos`() {
        resultadoListagemTodos = repository.listarTodos()
    }

    private fun `quando eu listar os contatos favoritos`() {
        resultadoListagemFavoritos = repository.listarFavoritos()
    }

    private fun `quando eu buscar um contato pelo id`() {
        resultadoBuscarPorId = repository.buscarPorId(1)
    }

    private fun `quando eu favoritar um contato`() {
        resultadoFavoritar = repository.favoritar(umContato)
    }

    private fun `entao eu devo receber uma lista vazia de contatos`() {
        verify { api.listarTodos() }

        assertTrue(resultadoListagemTodos.isEmpty())
    }

    private fun `entao eu devo receber uma lista com um contato`() {
        verify { api.listarTodos() }

        assertTrue(resultadoListagemTodos.size == 1)
    }

    private fun `entao eu devo receber uma lista com cinco contatos`() {
        verify { api.listarTodos() }

        assertTrue(resultadoListagemTodos.size == 5)
    }

    private fun `entao eu devo receber uma lista vazia de contatos favoritos`() {
        verify { dao.listarTodos() }

        assertTrue(resultadoListagemFavoritos.isEmpty())
    }

    private fun `entao eu devo receber uma lista com um contato favorito`() {
        verify { dao.listarTodos() }

        assertTrue(resultadoListagemFavoritos.size == 1)
    }

    private fun `entao eu devo receber uma lista com cinco contatos favoritos`() {
        verify { dao.listarTodos() }

        assertTrue(resultadoListagemFavoritos.size == 5)
    }

    private fun `entao eu nao devo receber um contato pelo id`() {
        verify { api.buscarPorId(any()) }

        verify(exactly = 0) { dao.buscarPorContatoId(any()) }

        assertTrue(resultadoBuscarPorId == null)
    }

    private fun `entao eu devo receber um contato nao favorito pelo id`() {
        verify { api.buscarPorId(any()) }

        verify { dao.buscarPorContatoId(any()) }

        assertTrue(resultadoBuscarPorId != null)

        assertTrue(resultadoBuscarPorId?.favoritoId == null)
    }

    private fun `entao eu devo receber um contato favorito pelo id`() {
        verify { api.buscarPorId(any()) }

        verify { dao.buscarPorContatoId(any()) }

        assertTrue(resultadoBuscarPorId != null)

        assertTrue(resultadoBuscarPorId?.favoritoId != null)
    }

    private fun `entao eu devo receber um contato marcado como favorito`() {
        verify { dao.buscarPorContatoId(any()) }

        verify { dao.inserir(any()) }

        verify(exactly = 0) { dao.deletar(any()) }

        assertTrue(resultadoFavoritar != null)

        assertTrue(resultadoFavoritar?.favoritoId != null)
    }

    private fun `entao eu devo receber um contato nao favorito`() {
        verify { dao.buscarPorContatoId(any()) }

        verify(exactly = 0) { dao.inserir(any()) }

        verify { dao.deletar(any()) }

        assertTrue(resultadoFavoritar != null)

        assertTrue(resultadoFavoritar?.favoritoId == null)
    }

}