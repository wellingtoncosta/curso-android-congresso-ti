package io.github.wellingtoncosta.cursoandroidcongressodeti.services.local.contact.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Contact(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val email: String,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String
)