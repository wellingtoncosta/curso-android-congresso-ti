package io.github.wellingtoncosta.cursoandroidcongressodeti.infrastructure.local

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.wellingtoncosta.cursoandroidcongressodeti.infrastructure.local.contact.ContactDao
import io.github.wellingtoncosta.cursoandroidcongressodeti.infrastructure.local.contact.FavoriteContactDao
import io.github.wellingtoncosta.cursoandroidcongressodeti.infrastructure.local.contact.entity.ContactEntity
import io.github.wellingtoncosta.cursoandroidcongressodeti.infrastructure.local.contact.entity.FavoriteContactEntity

@Database(
    version = 1,
    entities = [ContactEntity::class, FavoriteContactEntity::class],
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    abstract fun favoriteContactDao(): FavoriteContactDao

    companion object {
        const val DATABASE_NAME = "curso-android-congresso-ti-db"
    }


}