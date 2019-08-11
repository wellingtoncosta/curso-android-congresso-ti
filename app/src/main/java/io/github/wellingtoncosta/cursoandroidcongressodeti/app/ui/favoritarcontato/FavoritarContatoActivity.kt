package io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.favoritarcontato

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import io.github.wellingtoncosta.cursoandroidcongressodeti.R
import io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.listarcontatos.todos.ListaContatosFragment.Companion.CONTATO_ID
import io.github.wellingtoncosta.cursoandroidcongressodeti.databinding.ActivityFavoritarContatoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritarContatoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoritarContatoBinding

    private val buscarContatoPorIdViewModel by viewModel<BuscarContatoPorIdViewModel>()

    private val favoritarContatoViewModel by viewModel<FavoritarContatoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        buscarContatoPeloId()

        configurarBinding()

        configurarToolbar()

        observarContato()

        observarFavoritarCarregando()

        observarErro()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) { finish() }

        return super.onOptionsItemSelected(item)
    }

    private fun buscarContatoPeloId() {
        intent.extras?.let {
            if(intent.hasExtra(CONTATO_ID)) {
                Log.d("CONTATO_ID", it.getInt(CONTATO_ID).toString())

                buscarContatoPorIdViewModel.buscarContatoPorId(it.getInt(CONTATO_ID))
            }
        }
    }

    private fun configurarBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_favoritar_contato)

        binding.lifecycleOwner = this

        binding.buscarContatoPorIdViewModel = buscarContatoPorIdViewModel

        binding.favoritarContatoViewModel = favoritarContatoViewModel
    }

    private fun configurarToolbar() {
        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun observarContato() {
        buscarContatoPorIdViewModel.contato.observe(this, Observer {
            Log.d("CONTATO_POR_ID", it.toString())

            val iconResId = if(it.favoritoId == null) R.drawable.ic_full_heart
                            else R.drawable.ic_outline_heart

            binding.buttonFavoritarContato.setImageDrawable(
                ContextCompat.getDrawable(this, iconResId)
            )
        })
    }

    private fun observarFavoritarCarregando() {
        favoritarContatoViewModel.carregando.observe(this, Observer {
           if(!it) buscarContatoPeloId()
        })
    }

    private fun observarErro() {
        buscarContatoPorIdViewModel.erro.observe(this, Observer {
            exibirToastErro()
        })

        favoritarContatoViewModel.erro.observe(this, Observer {
            exibirToastErro()
        })
    }

    private fun exibirToastErro() {
        Toast.makeText(
            this, R.string.falha_favoritar_contato, Toast.LENGTH_LONG
        ).show()
    }

}
