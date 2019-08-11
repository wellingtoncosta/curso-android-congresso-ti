package io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.listarcontatos.todos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import io.github.wellingtoncosta.cursoandroidcongressodeti.R
import io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.favoritarcontato.FavoritarContatoActivity
import io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.listarcontatos.ListaContatosAdapter
import io.github.wellingtoncosta.cursoandroidcongressodeti.databinding.FragmentListaContatosBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListaContatosFragment : Fragment() {

    private val viewModel by viewModel<ListaContatosViewModel>()

    private lateinit var binding: FragmentListaContatosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_lista_contatos, container, false
        )

        binding.swipeLayout.setOnRefreshListener { viewModel.listarTodos() }

        binding.recyclerView.adapter = ListaContatosAdapter(::irParaTelaFavoritarContato)

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        observarCarregando()

        observarContatos()

        observarErro()

        viewModel.listarTodos()
    }

    private fun irParaTelaFavoritarContato(contatoId: Int) {
        Log.d("CONTATO_SELECIONADO", contatoId.toString())

        val intent = Intent(activity, FavoritarContatoActivity::class.java)

        intent.putExtra(CONTATO_ID, contatoId)

        startActivity(intent)
    }

    private fun observarCarregando() {
        viewModel.carregando.observe(viewLifecycleOwner, Observer {
            Log.d("CARREGANDO", it.toString())

            binding.swipeLayout.isRefreshing = it
        })
    }

    private fun observarContatos() {
        viewModel.contatos.observe(viewLifecycleOwner, Observer {
            (binding.recyclerView.adapter as ListaContatosAdapter)
                .atualizarContatos(it)
        })
    }

    private fun observarErro() {
        viewModel.erro.observe(viewLifecycleOwner, Observer {
            Toast.makeText(
                activity, R.string.falha_carregar_contatos, Toast.LENGTH_LONG
            ).show()
        })
    }

    companion object {
        const val CONTATO_ID = "contato-id"
    }

}
