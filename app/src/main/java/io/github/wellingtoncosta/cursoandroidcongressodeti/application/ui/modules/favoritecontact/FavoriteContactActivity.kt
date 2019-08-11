package io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.favoritecontact

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import io.github.wellingtoncosta.cursoandroidcongressodeti.R
import io.github.wellingtoncosta.cursoandroidcongressodeti.databinding.ActivityFavoriteContactBinding

class FavoriteContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this, R.layout.activity_favorite_contact)

        configureToolbar()
    }

    private fun configureToolbar() {
        setSupportActionBar(binding.favoriteContactToolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
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
