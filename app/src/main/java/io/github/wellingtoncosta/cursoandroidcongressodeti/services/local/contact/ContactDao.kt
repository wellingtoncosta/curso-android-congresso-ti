package io.github.wellingtoncosta.cursoandroidcongressodeti.services.local.contact

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.local.contact.entity.ContactEntity

@Dao
interface ContactDao {

    @Query(
        """
        SELECT *
        FROM contacts;
        """
    )
    fun getAllContacts(): List<ContactEntity>

    @Query(
        """
        SELECT contacts.*
        FROM contacts
        WHERE contacts.id = :contactId;
        """
    )
    fun getContactById(contactId: Int): ContactEntity?

    @Query(
        """
        SELECT contacts.*
        FROM contacts
        INNER JOIN favorite_contacts ON favorite_contacts.contact_id = contacts.id;
        """
    )
    fun getAllFavoriteContacts(): List<ContactEntity>

    @Query(
        """
        SELECT contacts.*
        FROM contacts
        INNER JOIN favorite_contacts ON favorite_contacts.contact_id = contacts.id
        WHERE contacts.id = :contactId;
        """
    )
    fun getFavoriteContactById(contactId: Int): ContactEntity?

    @Insert
    fun insert(contactEntity: ContactEntity): Long

    @Delete
    fun delete(contactEntity: ContactEntity)

}