package io.github.wellingtoncosta.cursoandroidcongressodeti.application.config

import androidx.room.Room
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.main.selectcontact.viewmodels.SelectContactViewModel
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.main.selectcontact.viewmodels.SelectFavoriteContactViewModel
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.viewmodels.FindContactByIdViewModel
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.viewmodels.UpdateFavoriteContactViewModel
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.repositories.contact.ContactRepository
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.local.AppDatabase
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.local.AppDatabase.Companion.DATABASE_NAME
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.remote.contact.ContactApiDataSource
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.remote.contact.ContactFuelApiDataSource
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.remote.contact.repository.ContactRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    single { get<AppDatabase>().contactDao() }

    single { get<AppDatabase>().favoriteContactDao() }
}

val networkModule = module {
    single<ContactApiDataSource> { ContactFuelApiDataSource() }
}

val repositoryModule = module {
    single<ContactRepository> { ContactRepositoryImpl(get(), get(), get()) }
}

val viewModelModule = module {
    viewModel { SelectContactViewModel(get()) }

    viewModel { SelectFavoriteContactViewModel(get()) }

    viewModel { FindContactByIdViewModel(get()) }

    viewModel { UpdateFavoriteContactViewModel(get()) }
}