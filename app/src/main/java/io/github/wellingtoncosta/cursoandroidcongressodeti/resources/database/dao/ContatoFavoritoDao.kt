package io.github.wellingtoncosta.cursoandroidcongressodeti.resources.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.database.entity.ContatoFavoritoEntity

@Dao interface ContatoFavoritoDao {

    @Query("SELECT * FROM tb_contato_favorito")
    fun listarTodos(): List<ContatoFavoritoEntity>

    @Query("""
        SELECT * FROM tb_contato_favorito
        WHERE contatoId = :contatoId
    """)
    fun buscarPorContatoId(contatoId: Int): ContatoFavoritoEntity?

    @Insert
    fun inserir(contatoFavoritoEntity: ContatoFavoritoEntity): Long

    @Delete
    fun deletar(contatoFavoritoEntity: ContatoFavoritoEntity)

}