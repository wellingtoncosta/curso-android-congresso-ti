package io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.listarcontatos.favoritos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import io.github.wellingtoncosta.cursoandroidcongressodeti.R
import io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.listarcontatos.ListaContatosAdapter
import io.github.wellingtoncosta.cursoandroidcongressodeti.databinding.FragmentListaContatosFavoritosBinding

class ListaContatosFavoritosFragment : Fragment() {

    private lateinit var binding: FragmentListaContatosFavoritosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_lista_contatos_favoritos, container, false
        )

        binding.recyclerView.adapter = ListaContatosAdapter()

        return binding.root
    }


}
