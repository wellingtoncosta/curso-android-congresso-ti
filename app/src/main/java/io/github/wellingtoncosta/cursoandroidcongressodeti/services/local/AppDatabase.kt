package io.github.wellingtoncosta.cursoandroidcongressodeti.services.local

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.local.contact.FavoriteContactDao
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.local.contact.entity.ContactEntity
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.local.contact.entity.FavoriteContactEntity

@Database(
    version = 1,
    entities = [ContactEntity::class, FavoriteContactEntity::class],
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteContactDao(): FavoriteContactDao

    companion object {
        const val DATABASE_NAME = "curso-android-congresso-ti-db"
    }


}