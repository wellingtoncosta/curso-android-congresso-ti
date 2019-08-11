package io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.favoritecontact

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.Observer
import io.github.wellingtoncosta.cursoandroidcongressodeti.R
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.viewmodels.FindContactByIdViewModel
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.viewmodels.UpdateFavoriteContactViewModel
import io.github.wellingtoncosta.cursoandroidcongressodeti.databinding.ActivityFavoriteContactBinding
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.models.contact.Contact
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteContactBinding

    private val findContactByIdViewModel by viewModel<FindContactByIdViewModel>()
    private val updateFavoriteContactViewModel by viewModel<UpdateFavoriteContactViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configureDataBinding()

        configureToolbar()
    }

    private fun configureDataBinding() {
        binding = setContentView(this, R.layout.activity_favorite_contact)

        binding.lifecycleOwner = this
    }

    private fun configureToolbar() {
        setSupportActionBar(binding.favoriteContactToolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onStart() {
        super.onStart()

        configureViewModelObservers()
    }

    private fun configureViewModelObservers() {
        configureFindContactByIdObserver()

        configureUpdateFavoriteContactObserver()
    }

    private fun configureFindContactByIdObserver() {
        findContactByIdViewModel.contact.observe(this, Observer { contact ->
            binding.contact = contact
        })
    }

    private fun configureUpdateFavoriteContactObserver() {
        updateFavoriteContactViewModel.favorite.observe(this, Observer { isFavorite ->
            val drawableId =
                if (isFavorite) R.drawable.ic_outline_favorite_24px
                else R.drawable.ic_outline_favorite_border_24px

            binding.favoriteContactFloatingActionButton.setImageDrawable(
                ContextCompat.getDrawable(this, drawableId)
            )
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}
