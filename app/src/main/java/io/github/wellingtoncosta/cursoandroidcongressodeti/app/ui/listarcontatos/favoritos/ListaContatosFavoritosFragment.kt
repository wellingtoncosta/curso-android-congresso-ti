package io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.listarcontatos.favoritos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import io.github.wellingtoncosta.cursoandroidcongressodeti.R
import io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.listarcontatos.ListaContatosAdapter
import io.github.wellingtoncosta.cursoandroidcongressodeti.databinding.FragmentListaContatosFavoritosBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListaContatosFavoritosFragment : Fragment() {

    private lateinit var binding: FragmentListaContatosFavoritosBinding

    private val viewModel by viewModel<ListaContatosFavoritosViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_lista_contatos_favoritos, container, false
        )

        binding.swipeLayout.setOnRefreshListener { viewModel.listarFavoritos() }

        binding.recyclerView.adapter = ListaContatosAdapter()

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        observarCarregando()

        observarFavoritos()

        observarErro()

        viewModel.listarFavoritos()
    }

    private fun observarCarregando() {
        viewModel.carregando.observe(viewLifecycleOwner, Observer {
            Log.d("CARREGANDO_FAVORITOS", it.toString())

            binding.swipeLayout.isRefreshing = it
        })
    }

    private fun observarFavoritos() {
        viewModel.favoritos.observe(viewLifecycleOwner, Observer {
            Log.d("CONTATOS_FAVORITOS", it.toString())

            (binding.recyclerView.adapter as ListaContatosAdapter)
                .atualizarContatos(it)
        })
    }

    private fun observarErro() {
        viewModel.erro.observe(viewLifecycleOwner, Observer {
            Toast.makeText(
                activity, R.string.falha_carregar_contatos_favoritos, Toast.LENGTH_LONG
            ).show()
        })
    }

}
