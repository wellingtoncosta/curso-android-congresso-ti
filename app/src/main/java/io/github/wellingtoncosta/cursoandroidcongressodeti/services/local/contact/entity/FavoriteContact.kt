package io.github.wellingtoncosta.cursoandroidcongressodeti.services.local.contact.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "favorite_contacts"
)
data class FavoriteContact(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "contact_id")
    @ForeignKey(
        entity = Contact::class,
        parentColumns = ["contact_id"],
        onDelete = CASCADE,
        childColumns = ["contact_id"]
    )
    val contactId: Int
)