package io.github.wellingtoncosta.cursoandroidcongressodeti.services.remote.contact.repository

import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.extensions.executors.runAsync
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.models.contact.Contact
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.repositories.contact.ContactRepository
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.local.contact.ContactDao
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.local.contact.FavoriteContactDao
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.local.contact.entity.FavoriteContactEntity
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.local.contact.entity.toModel
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.remote.contact.ContactApiDataSource
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.remote.contact.responses.toEntity
import io.github.wellingtoncosta.cursoandroidcongressodeti.services.remote.contact.responses.toModel

class ContactRepositoryImpl(
    private val contactApiDataSource: ContactApiDataSource,
    private val contactDao: ContactDao,
    private val favoriteContactDao: FavoriteContactDao
) : ContactRepository {

    override fun getAllContacts(): List<Contact> {
        return runAsync {
            val allContacts = contactApiDataSource.getAllContacts()

            allContacts.map {
                contactDao.insert(it.toEntity())
                it.toModel()
            }
        }
    }

    override fun getAllFavoriteContacts(): List<Contact> {
        return runAsync {
            val allFavoriteContacts = contactDao.getAllFavoriteContacts()

            allFavoriteContacts.map {
                it.toModel()
            }
        }

    }

    override fun getContactById(contactId: Int): Contact? {
        return runAsync {
            contactDao.getContactById(contactId)?.toModel()
        }
    }

    override fun favorite(contact: Contact) {
        return runAsync {
            val favoriteContact = contactDao.getFavoriteContactById(contactId = contact.id)

            if (favoriteContact != null) {
                favoriteContactDao.delete(
                    favoriteContactEntity = favoriteContactDao.getFavoriteContactById(
                        favoriteContact.favoriteId
                    )
                )
            } else {
                favoriteContactDao.insert(
                    FavoriteContactEntity(contactId = contact.id)
                )
            }
        }
    }


}