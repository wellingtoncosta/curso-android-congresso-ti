package io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.listarcontatos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import io.github.wellingtoncosta.cursoandroidcongressodeti.R
import io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.listarcontatos.favoritos.ListaContatosFavoritosFragment
import io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui.listarcontatos.todos.ListaContatosFragment
import io.github.wellingtoncosta.cursoandroidcongressodeti.databinding.ActivityListaContatosBinding

class ListaContatosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaContatosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_lista_contatos)

        configurarAbas()
    }

    private fun configurarAbas() {
        val adapter = ViewPagerAdapter(
            supportFragmentManager
        )

        adapter.addPage(
            FragmentPage(
                ListaContatosFragment(),
                getString(R.string.contatos)
            )
        )

        adapter.addPage(
            FragmentPage(
                ListaContatosFavoritosFragment(),
                getString(R.string.favoritos)
            )
        )

        binding.viewPager.adapter = adapter

        binding.tabs.setupWithViewPager(binding.viewPager)
    }

}
