package io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.listarcontatos.favoritos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.entity.Contato
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.repository.ContatoRepository
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.extension.doInBackground

class ListaContatosFavoritosViewModel(
    private val repository: ContatoRepository
) : ViewModel() {

    private val _carregando = MutableLiveData<Boolean>()
    private val _favoritos = MutableLiveData<List<Contato>>()
    private val _erro = MutableLiveData<Throwable>()

    val carregando: LiveData<Boolean> get() =_carregando
    val favoritos: LiveData<List<Contato>> get() = _favoritos
    val erro: LiveData<Throwable> get() = _erro

    fun listarFavoritos() {
        doInBackground {
            try {
                
                _carregando.postValue(true)

                _favoritos.postValue(repository.listarFavoritos())

            } catch (e: Throwable) {

                _erro.postValue(e)

                e.message?.let { Log.e("listarFavoritos()", it) }

            } finally {
                _carregando.postValue(false)
            }
        }
    }

}