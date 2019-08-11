package io.github.wellingtoncosta.cursoandroidcongressodeti.infrastructure.local.contact.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.models.contact.Contact

@Entity(tableName = "contacts")
data class ContactEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val email: String,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String
)

fun ContactEntity.toModel(): Contact {
    return Contact(
        id = this.id,
        name = this.name,
        email = this.email,
        phoneNumber = this.phoneNumber
    )
}