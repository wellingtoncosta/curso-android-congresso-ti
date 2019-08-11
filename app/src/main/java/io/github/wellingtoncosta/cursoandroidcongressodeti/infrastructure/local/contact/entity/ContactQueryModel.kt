package io.github.wellingtoncosta.cursoandroidcongressodeti.infrastructure.local.contact.entity

import androidx.room.ColumnInfo
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.models.contact.Contact

class ContactQueryModel(
    val id: Int,
    val name: String,
    val email: String,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String,
    @ColumnInfo(name = "favorite_id")
    val favoriteId: Int
)

fun ContactQueryModel.toModel(): Contact {
    return Contact(
        id = this.id,
        name = this.name,
        email = this.email,
        phoneNumber = this.phoneNumber,
        favoriteId = this.favoriteId
    )
}