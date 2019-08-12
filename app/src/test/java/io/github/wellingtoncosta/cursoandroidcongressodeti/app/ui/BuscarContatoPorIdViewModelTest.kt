package io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui

import androidx.lifecycle.Observer
import io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.favoritarcontato.BuscarContatoPorIdViewModel
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.entity.Contato
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.exception.NetworkException
import io.github.wellingtoncosta.cursoandroidcongressodeti.testutil.mock.ContatoMocks.umContato
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Test

class BuscarContatoPorIdViewModelTest : BaseViewModelTest() {

    private val contatoObserver = mockk<Observer<Contato>>()

    private val viewModel = BuscarContatoPorIdViewModel(executor, repository)

    private var resultadoBuscarContatoPorId: Contato? = null

    @Test fun `sem interacoes`() {

        `dado que eu tenha os observers configurados`()

        `entao nao devo ter interacoes`()

    }

    @Test fun `buscar contato existente por id`() {

        `dado que eu tenha um contato existente por id`()

        `quando eu buscar um contato pelo id`()

        `entao devo receber um contato existente por id`()

    }

    @Test fun `buscar contato inexistente por id`() {

        `dado que eu tenha um contato inexistente por id`()

        `quando eu buscar um contato pelo id`()

        `entao devo receber um contato inexistente por id`()

    }

    @Test fun `buscar contato por id com falha`() {

        `dado que eu tenha uma falha ao buscar contato por id`()

        `quando eu buscar um contato pelo id`()

        `entao devo receber uma falha`()

    }

    private fun `dado que eu tenha os observers configurados`() {

        every { contatoObserver.onChanged(any()) } just Runs

        every { carregandoObserver.onChanged(any()) } just Runs

        every { erroObserver.onChanged(any()) } just Runs

        viewModel.contato.observeForever(contatoObserver)

        viewModel.carregando.observeForever(carregandoObserver)

        viewModel.erro.observeForever(erroObserver)

    }

    private fun `dado que eu tenha um contato existente por id`() {

        `dado que eu tenha os observers configurados`()

        resultadoBuscarContatoPorId = umContato

        every { repository.buscarPorId(any()) } returns resultadoBuscarContatoPorId

    }

    private fun `dado que eu tenha um contato inexistente por id`() {

        `dado que eu tenha os observers configurados`()

        resultadoBuscarContatoPorId = null

        every { repository.buscarPorId(any()) } returns resultadoBuscarContatoPorId

    }

    private fun `dado que eu tenha uma falha ao buscar contato por id`() {

        `dado que eu tenha os observers configurados`()

        every { repository.buscarPorId(any()) } throws NetworkException()

    }

    private fun `quando eu buscar um contato pelo id`() {

        viewModel.buscarContatoPorId(1)

    }

    private fun `entao nao devo ter interacoes`() {

        verify(exactly = 0) { repository.buscarPorId(any()) }

        verify(exactly = 0) { contatoObserver.onChanged(any()) }

        verify(exactly = 0) { carregandoObserver.onChanged(any()) }

        verify(exactly = 0) { erroObserver.onChanged(any()) }

    }

    private fun `entao devo receber um contato existente por id`() {

        verify { contatoObserver.onChanged(any()) }

        verify(exactly = 2) { carregandoObserver.onChanged(any()) }

        verify(exactly = 0) { erroObserver.onChanged(any()) }

        Assert.assertTrue(viewModel.contato.value != null)

        Assert.assertTrue(viewModel.contato.value == resultadoBuscarContatoPorId)

    }

    private fun `entao devo receber um contato inexistente por id`() {

        verify { contatoObserver.onChanged(any()) }

        verify(exactly = 2) { carregandoObserver.onChanged(any()) }

        verify(exactly = 0) { erroObserver.onChanged(any()) }

        Assert.assertTrue(viewModel.contato.value == null)

    }

    private fun `entao devo receber uma falha`() {

        verify(exactly = 0) { contatoObserver.onChanged(any()) }

        verify(exactly = 2) { carregandoObserver.onChanged(any()) }

        verify { erroObserver.onChanged(any()) }

    }

}