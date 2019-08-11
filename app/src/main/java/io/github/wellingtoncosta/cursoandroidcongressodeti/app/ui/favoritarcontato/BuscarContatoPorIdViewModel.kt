package io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.favoritarcontato

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.entity.Contato
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.repository.ContatoRepository
import io.github.wellingtoncosta.cursoandroidcongressodeti.resources.extension.doInBackground

class BuscarContatoPorIdViewModel (
    private val repository: ContatoRepository
): ViewModel() {

    private val _carregando = MutableLiveData<Boolean>()
    private val _contato = MutableLiveData<Contato>()
    private val _erro = MutableLiveData<Throwable>()

    val carregando: LiveData<Boolean> get() = _carregando
    val contato: LiveData<Contato> get() = _contato
    val erro: LiveData<Throwable> get() = _erro

    fun buscarContatoPorId(contatoId: Int) {
        doInBackground {
            try {

                _carregando.postValue(true)

                _contato.postValue(repository.buscarPorId(contatoId))

            } catch (e: Throwable) {

                _erro.postValue(e)

                e.message?.let { Log.e("buscarContatoPorId()", it) }

            } finally {
                _carregando.postValue(false)
            }
        }
    }

}