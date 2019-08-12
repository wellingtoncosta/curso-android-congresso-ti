package io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui

import androidx.lifecycle.Observer
import io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.listarcontatos.todos.ListaContatosViewModel
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

class ListaContatosViewModelTest : BaseViewModelTest() {

    private val contatosObserver = mockk<Observer<List<Contato>>>()

    private val viewModel = ListaContatosViewModel(executor, repository)

    private lateinit var resultadoListagemContatos: List<Contato>

    @Test fun `sem interacoes`() {

        `dado que eu tenha os observers configurados`()

        `entao nao devo ter interacoes`()

    }

    @Test fun `listar contatos com um resultado`() {

        `dado que eu tenha uma lista com um contato`()

        `quando eu listar os contatos`()

        `entao devo receber uma lista com um contato`()

    }

    @Test fun `listar contatos com cinco resultados`() {

        `dado que eu tenha uma lista com cinco contatos`()

        `quando eu listar os contatos`()

        `entao devo receber uma lista com cinco contatos`()

    }

    @Test fun `listar contatos com falha`() {

        `dado que eu tenha uma lista de contatos com falha`()

        `quando eu listar os contatos`()

        `entao devo receber uma falha`()

    }

    private fun `dado que eu tenha os observers configurados`() {

        every { contatosObserver.onChanged(any()) } just Runs

        every { carregandoObserver.onChanged(any()) } just Runs

        every { erroObserver.onChanged(any()) } just Runs

        viewModel.contatos.observeForever(contatosObserver)

        viewModel.carregando.observeForever(carregandoObserver)

        viewModel.erro.observeForever(erroObserver)

    }

    private fun `dado que eu tenha uma lista com um contato`() {

        `dado que eu tenha os observers configurados`()

        resultadoListagemContatos = listOf(umContato)

        every { repository.listarTodos() } returns resultadoListagemContatos

    }

    private fun `dado que eu tenha uma lista com cinco contatos`() {

        `dado que eu tenha os observers configurados`()

        resultadoListagemContatos = cincoContatos

        every { repository.listarTodos() } returns resultadoListagemContatos

    }

    private fun `dado que eu tenha uma lista de contatos com falha`() {

        `dado que eu tenha os observers configurados`()

        every { repository.listarTodos() } throws NetworkException()

    }

    private fun `quando eu listar os contatos`() {

        viewModel.listarTodos()

    }

    private fun `entao nao devo ter interacoes`() {

        verify(exactly = 0) { repository.listarTodos() }

        verify(exactly = 0) { contatosObserver.onChanged(any()) }

        verify(exactly = 0) { carregandoObserver.onChanged(any()) }

        verify(exactly = 0) { erroObserver.onChanged(any()) }

    }

    private fun `entao devo receber uma lista com um contato`() {

        verify { contatosObserver.onChanged(any()) }

        verify(exactly = 2) { carregandoObserver.onChanged(any()) }

        verify(exactly = 0) { erroObserver.onChanged(any()) }

        assertTrue(viewModel.contatos.value?.size == 1)

        assertTrue(viewModel.contatos.value == resultadoListagemContatos)

    }

    private fun `entao devo receber uma lista com cinco contatos`() {

        verify { contatosObserver.onChanged(any()) }

        verify(exactly = 2) { carregandoObserver.onChanged(any()) }

        verify(exactly = 0) { erroObserver.onChanged(any()) }

        assertTrue(viewModel.contatos.value?.size == 5)

        assertTrue(viewModel.contatos.value == resultadoListagemContatos)

    }

    private fun `entao devo receber uma falha`() {

        verify(exactly = 0) { contatosObserver.onChanged(any()) }

        verify(exactly = 2) { carregandoObserver.onChanged(any()) }

        verify { erroObserver.onChanged(any()) }

    }

}