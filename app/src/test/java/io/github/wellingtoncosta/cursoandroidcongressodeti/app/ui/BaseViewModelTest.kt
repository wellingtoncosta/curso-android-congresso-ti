package io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.repository.ContatoRepository
import io.github.wellingtoncosta.cursoandroidcongressodeti.testutil.CurrentThreadExecutorService
import io.mockk.mockk
import org.junit.Rule

open class BaseViewModelTest {

    @get:Rule val instantTaskExecutorRule = InstantTaskExecutorRule()

    protected val carregandoObserver = mockk<Observer<Boolean>>()

    protected val erroObserver = mockk<Observer<Throwable>>()

    protected val executor = CurrentThreadExecutorService()

    protected val repository = mockk<ContatoRepository>()

}