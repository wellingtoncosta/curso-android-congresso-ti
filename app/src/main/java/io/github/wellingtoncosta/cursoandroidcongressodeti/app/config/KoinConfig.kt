package io.github.wellingtoncosta.cursoandroidcongressodeti.app.config

import androidx.room.Room
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.repository.ContatoRepository
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.database.AppDatabase
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.database.AppDatabase.Companion.DATABASE_NAME
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network.ContatoApi
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.network.fuel.ContatoFuelApi
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.repository.ContatoRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    single { get<AppDatabase>().contatoFavoritoDao() }
}

val networkModule = module {
    single<ContatoApi> { ContatoFuelApi() }
}

val repositoryModule = module {
    single<ContatoRepository> { ContatoRepositoryImpl(get(), get()) }
}
