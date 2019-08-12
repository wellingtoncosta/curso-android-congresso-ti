package io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui

import androidx.lifecycle.Observer
import io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.listarcontatos.favoritos.ListaContatosFavoritosViewModel
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.entity.Contato
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.exception.NetworkException
import io.github.wellingtoncosta.cursoandroidcongressodeti.testutil.mock.ContatoMocks.cincoContatos
import io.github.wellingtoncosta.cursoandroidcongressodeti.testutil.mock.ContatoMocks.umContato
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertTrue
import org.junit.Test

class ListaContatosFavoritosViewModelTest : BaseViewModelTest() {

    private val favoritosObserver = mockk<Observer<List<Contato>>>()

    private val viewModel = ListaContatosFavoritosViewModel(executor, repository)

    private lateinit var resultadoListagemContatos: List<Contato>

    @Test fun `sem interacoes`() {

        `dado que eu tenha os observers configurados`()

        `entao nao devo ter interacoes`()

    }

    @Test fun `listar contatos favoritos com um resultado`() {

        `dado que eu tenha uma lista com um contato favorito`()

        `quando eu listar os contatos favoritos`()

        `entao devo receber uma lista com um contato favorito`()

    }

    @Test fun `listar contatos favoritos com cinco resultados`() {

        `dado que eu tenha uma lista com cinco contatos favoritos`()

        `quando eu listar os contatos favoritos`()

        `entao devo receber uma lista com cinco contatos favoritos`()

    }

    @Test fun `listar contatos favoritos com falha`() {

        `dado que eu tenha uma lista de contatos favoritos com falha`()

        `quando eu listar os contatos favoritos`()

        `entao devo receber uma falha`()

    }

    private fun `dado que eu tenha os observers configurados`() {

        every { favoritosObserver.onChanged(any()) } just Runs

        every { carregandoObserver.onChanged(any()) } just Runs

        every { erroObserver.onChanged(any()) } just Runs

        viewModel.favoritos.observeForever(favoritosObserver)

        viewModel.carregando.observeForever(carregandoObserver)

        viewModel.erro.observeForever(erroObserver)

    }

    private fun `dado que eu tenha uma lista com um contato favorito`() {

        `dado que eu tenha os observers configurados`()

        resultadoListagemContatos = listOf(umContato)

        every { repository.listarFavoritos() } returns resultadoListagemContatos

    }

    private fun `dado que eu tenha uma lista com cinco contatos favoritos`() {

        `dado que eu tenha os observers configurados`()

        resultadoListagemContatos = cincoContatos

        every { repository.listarFavoritos() } returns resultadoListagemContatos

    }

    private fun `dado que eu tenha uma lista de contatos favoritos com falha`() {

        `dado que eu tenha os observers configurados`()

        every { repository.listarFavoritos() } throws NetworkException()

    }

    private fun `quando eu listar os contatos favoritos`() {

        viewModel.listarFavoritos()

    }

    private fun `entao nao devo ter interacoes`() {

        verify(exactly = 0) { repository.listarFavoritos() }

        verify(exactly = 0) { favoritosObserver.onChanged(any()) }

        verify(exactly = 0) { carregandoObserver.onChanged(any()) }

        verify(exactly = 0) { erroObserver.onChanged(any()) }

    }

    private fun `entao devo receber uma lista com um contato favorito`() {

        verify { favoritosObserver.onChanged(any()) }

        verify(exactly = 2) { carregandoObserver.onChanged(any()) }

        verify(exactly = 0) { erroObserver.onChanged(any()) }

        assertTrue(viewModel.favoritos.value?.size == 1)

        assertTrue(viewModel.favoritos.value == resultadoListagemContatos)

    }

    private fun `entao devo receber uma lista com cinco contatos favoritos`() {

        verify { favoritosObserver.onChanged(any()) }

        verify(exactly = 2) { carregandoObserver.onChanged(any()) }

        verify(exactly = 0) { erroObserver.onChanged(any()) }

        assertTrue(viewModel.favoritos.value?.size == 5)

        assertTrue(viewModel.favoritos.value == resultadoListagemContatos)

    }

    private fun `entao devo receber uma falha`() {

        verify(exactly = 0) { favoritosObserver.onChanged(any()) }

        verify(exactly = 2) { carregandoObserver.onChanged(any()) }

        verify { erroObserver.onChanged(any()) }

    }

}