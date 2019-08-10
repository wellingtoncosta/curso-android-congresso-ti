package io.github.wellingtoncosta.cursoandroidcongressodeti.services.local.contact

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.local.contact.entity.FavoriteContactEntity

@Dao
interface FavoriteContactDao {

    @Insert
    fun insert(favoriteContactEntity: FavoriteContactEntity): Long

    @Delete
    fun delete(favoriteContactEntity: FavoriteContactEntity)


}