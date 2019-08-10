package io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.github.wellingtoncosta.cursoandroidcongressodeti.R

class ListaContatosFavoritosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lista_contatos_favoritos, container, false)
    }


}
