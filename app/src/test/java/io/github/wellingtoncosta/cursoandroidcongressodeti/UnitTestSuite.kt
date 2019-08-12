package io.github.wellingtoncosta.cursoandroidcongressodeti

import io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.BuscarContatoPorIdViewModelTest
import io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.FavoritarContatoViewModelTest
import io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.ListaContatosFavoritosViewModelTest
import io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.ListaContatosViewModelTest
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network.ContatoFuelApiTest
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.repository.ContatoRepositoryImpTest
import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses

@RunWith(Suite::class)
@SuiteClasses(
    ContatoFuelApiTest::class,
    ContatoRepositoryImpTest::class,
    ListaContatosViewModelTest::class,
    ListaContatosFavoritosViewModelTest::class,
    BuscarContatoPorIdViewModelTest::class,
    FavoritarContatoViewModelTest::class
)
class UnitTestSuite