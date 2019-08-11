package io.github.wellingtoncosta.cursoandroidcongressodeti.infrastructure.local.contact

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.github.wellingtoncosta.cursoandroidcongressodeti.infrastructure.local.contact.entity.FavoriteContactEntity

@Dao
interface FavoriteContactDao {

    @Query(
        """
        SELECT *
        FROM favorite_contacts
        WHERE favorite_contacts.id = :id
        
        """
    )
    fun getFavoriteContactById(id: Int): FavoriteContactEntity

    @Insert
    fun insert(favoriteContactEntity: FavoriteContactEntity): Long

    @Delete
    fun delete(favoriteContactEntity: FavoriteContactEntity)


}