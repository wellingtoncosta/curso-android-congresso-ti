package io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network

import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.exception.NetworkException
import io.github.wellingtoncosta.cursoandroidcongressodeti.testutil.extension.asJson
import io.github.wellingtoncosta.cursoandroidcongressodeti.testutil.extension.dispatches
import io.github.wellingtoncosta.cursoandroidcongressodeti.testutil.extension.responses
import io.github.wellingtoncosta.cursoandroidcongressodeti.testutil.mock.startHttpServer
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network.entity.ContatoResponse
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network.fuel.ContatoFuelApi
import okhttp3.mockwebserver.MockWebServer
import org.junit.AfterClass
import org.junit.Assert.assertTrue
import org.junit.BeforeClass
import org.junit.Test

class ContatoFuelApiTest {

    private val api = ContatoFuelApi()

    private lateinit var resultadoListagem: List<ContatoResponse>

    private var resultadoPorId: ContatoResponse? = null

    private var contatoId: Int = 1

    @Test fun `listar contatos com resultado vazio`() {

        `dado que eu tenha uma resposta vazia de contatos`()

        `quando eu listar os contatos`()

        `entao devo receber uma lista vazia de contatos`()

    }

    @Test fun `listar contatos com um resultado`() {

        `dado que eu tenha uma resposta com um contato`()

        `quando eu listar os contatos`()

        `entao devo receber uma lista com um contato`()

    }

    @Test fun `listar contatos com cinco resultados`() {

        `dado que eu tenha uma resposta com cinco contatos`()

        `quando eu listar os contatos`()

        `entao devo receber uma lista com cinco contatos`()

    }

    @Test(expected = NetworkException::class)
    fun `listar contatos com falha`() {

        `dado que eu tenha uma resposta de falha`()

        `quando eu listar os contatos`()

    }

    @Test fun `buscar contato existente por id`() {

        `dado que eu tenha uma resposta de um contato pelo id`()

        `quando eu buscar o contato pelo id`()

        `entao devo receber um contato pelo id`()

    }

    @Test fun `buscar contato inexistente por id`() {

        `dado que eu tenha uma resposta de um contato inexistente pelo id`()

        `quando eu buscar o contato pelo id`()

        `entao devo receber um contato inexistente pelo id`()

    }

    @Test(expected = NetworkException::class)
    fun `buscar contato por id com falha`() {

        `dado que eu tenha uma resposta de um contato pelo id com falha`()

        `quando eu buscar o contato pelo id`()

    }

    private fun `dado que eu tenha uma resposta vazia de contatos`() {
        server.dispatcher = dispatches { path ->
            when (path) {
                "/contacts" -> 200 responses "/json/empty-list-response.json".asJson()
                else -> 404 responses null
            }
        }
    }

    private fun `dado que eu tenha uma resposta com um contato`() {
        server.dispatcher = dispatches { path ->
            when (path) {
                "/contacts" -> 200 responses "/json/um-contato-response.json".asJson()
                else -> 404 responses null
            }
        }
    }

    private fun `dado que eu tenha uma resposta com cinco contatos`() {
        server.dispatcher = dispatches { path ->
            when (path) {
                "/contacts" -> 200 responses "/json/cinco-contatos-response.json".asJson()
                else -> 404 responses null
            }
        }
    }

    private fun `dado que eu tenha uma resposta de falha`() {
        server.dispatcher = dispatches { path ->
            when (path) {
                "/contacts" -> 500 responses null
                else -> 404 responses null
            }
        }
    }

    private fun `dado que eu tenha uma resposta de um contato pelo id`() {
        server.dispatcher = dispatches { path ->
            when (path) {
                "/contacts/$contatoId" -> 200 responses "/json/um-contato-por-id-response.json".asJson()
                else -> 404 responses null
            }
        }
    }

    private fun `dado que eu tenha uma resposta de um contato inexistente pelo id`() {
        server.dispatcher = dispatches { path ->
            when (path) {
                "/contacts/$contatoId" -> 404 responses null
                else -> 404 responses null
            }
        }
    }

    private fun `dado que eu tenha uma resposta de um contato pelo id com falha`() {
        server.dispatcher = dispatches { path ->
            when (path) {
                "/contacts/$contatoId" -> 500 responses null
                else -> 404 responses null
            }
        }
    }

    private fun `quando eu listar os contatos`() {
        resultadoListagem = api.listarTodos()
    }

    private fun `quando eu buscar o contato pelo id`() {
        resultadoPorId = api.buscarPorId(contatoId)
    }

    private fun `entao devo receber uma lista vazia de contatos`() {
        assertTrue(resultadoListagem.isEmpty())
    }

    private fun `entao devo receber uma lista com um contato`() {
        assertTrue(resultadoListagem.size == 1)
    }

    private fun `entao devo receber uma lista com cinco contatos`() {
        assertTrue(resultadoListagem.size == 5)
    }

    private fun `entao devo receber um contato pelo id`() {
        assertTrue(resultadoPorId != null)
    }

    private fun `entao devo receber um contato inexistente pelo id`() {
        assertTrue(resultadoPorId == null)
    }

    companion object {

        private lateinit var server: MockWebServer

        @BeforeClass @JvmStatic fun beforeAll() {
            server = startHttpServer()
        }

        @AfterClass @JvmStatic fun afterAll() {
            server.shutdown()
        }

    }

}