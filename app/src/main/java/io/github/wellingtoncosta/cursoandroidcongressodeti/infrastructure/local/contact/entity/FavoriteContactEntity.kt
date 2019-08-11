package io.github.wellingtoncosta.cursoandroidcongressodeti.infrastructure.local.contact.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_contacts")
data class FavoriteContactEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "contact_id")
    @ForeignKey(
        entity = ContactEntity::class,
        parentColumns = ["contact_id"],
        onDelete = CASCADE,
        childColumns = ["contact_id"]
    )
    val contactId: Int
)