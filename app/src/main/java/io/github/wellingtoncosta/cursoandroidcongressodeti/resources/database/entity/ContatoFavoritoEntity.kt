package io.github.wellingtoncosta.cursoandroidcongressodeti.resources.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.entity.Contato

@Entity(tableName = "tb_contato_favorito")
data class ContatoFavoritoEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val nome: String,
    val email: String,
    val telefone: String,
    val contatoId: Int
)

fun ContatoFavoritoEntity.toDomain() = Contato(
    id = this.contatoId,
    nome = this.nome,
    email = this.email,
    telefone = this.telefone,
    favoritoId = this.id
)

fun Contato.toEntity() = ContatoFavoritoEntity(
    nome = this.nome,
    email = this.email,
    telefone = this.telefone,
    contatoId = this.id
)
