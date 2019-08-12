package io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui

import io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.favoritarcontato.FavoritarContatoViewModel
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.entity.Contato
import io.github.wellingtoncosta.cursoandroidcongressodeti.testutil.mock.ContatoMocks.umContato
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.verify
import org.junit.Test

class FavoritarContatoViewModelTest : BaseViewModelTest() {

    private val viewModel = FavoritarContatoViewModel(executor, repository)

    private lateinit var contato: Contato

    @Test fun `sem interacoes`() {

        `dado que eu tenha os observers configurados`()

        `entao nao devo ter interacoes`()

    }

    @Test fun `favoritar contato`() {

        `dado que eu tenha um contato nao favorito`()

        `quando eu favoritar um contato`()

        `entao devo receber um contato favorito`()

    }

    @Test fun `favoritar contato com falha`() {

        `dado que eu tenha uma falha ao favoritar um contato`()

        `quando eu favoritar um contato`()

        `entao devo receber uma falha ao favoritar um contato`()

    }

    private fun `dado que eu tenha os observers configurados`() {

        every { carregandoObserver.onChanged(any()) } just Runs

        every { erroObserver.onChanged(any()) } just Runs

        viewModel.carregando.observeForever(carregandoObserver)

        viewModel.erro.observeForever(erroObserver)

    }

    private fun `dado que eu tenha um contato nao favorito`() {

        `dado que eu tenha os observers configurados`()

        contato = umContato

        every { repository.favoritar(contato) } returns contato.copy(favoritoId = 1)

    }

    private fun `dado que eu tenha uma falha ao favoritar um contato`() {

        `dado que eu tenha os observers configurados`()

        contato = umContato

        every { repository.favoritar(contato) } throws RuntimeException()

    }

    private fun `quando eu favoritar um contato`() {

        viewModel.favoritar(contato)

    }

    private fun `entao nao devo ter interacoes`() {

        verify(exactly = 0) { repository.favoritar(any()) }

        verify(exactly = 0) { carregandoObserver.onChanged(any()) }

        verify(exactly = 0) { erroObserver.onChanged(any()) }

    }

    private fun `entao devo receber um contato favorito`() {

        verify { repository.favoritar(any()) }

        verify(exactly = 2) { carregandoObserver.onChanged(any()) }

        verify(exactly = 0) { erroObserver.onChanged(any()) }

    }

    private fun `entao devo receber uma falha ao favoritar um contato`() {

        verify { repository.favoritar(any()) }

        verify(exactly = 2) { carregandoObserver.onChanged(any()) }

        verify { erroObserver.onChanged(any()) }

    }

}
