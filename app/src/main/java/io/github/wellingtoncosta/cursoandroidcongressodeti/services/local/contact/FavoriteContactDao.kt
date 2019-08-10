package io.github.wellingtoncosta.cursoandroidcongressodeti.services.local.contact

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.local.contact.entity.ContactEntity
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.local.contact.entity.FavoriteContactEntity

@Dao
interface FavoriteContactDao {

    @Query(
        """
        SELECT contacts.*
        FROM contacts
        INNER JOIN favorite_contacts ON favorite_contacts.contact_id = contacts.id
        """
    )
    fun getAllFavoriteContacts(): List<ContactEntity>

    @Query(
        """
        SELECT contacts.*
        FROM contacts
        INNER JOIN favorite_contacts ON favorite_contacts.contact_id = contacts.id
        WHERE contacts.id = :contactId
        """
    )
    fun getFavoriteContactById(contactId: Int): ContactEntity?

    @Insert
    fun insert(favoriteContactEntity: FavoriteContactEntity): Long

    @Delete
    fun delete(favoriteContactEntity: FavoriteContactEntity)


}