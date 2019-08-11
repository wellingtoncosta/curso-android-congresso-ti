package io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.viewpager.widget.PagerAdapter
import io.github.wellingtoncosta.cursoandroidcongressodeti.R
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.adapters.pageadapter.CustomPagerAdapter
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.adapters.pageadapter.PageFragment
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.main.selectcontact.fragments.ContactFragment
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.main.selectcontact.fragments.FavoriteContactFragment
import io.github.wellingtoncosta.cursoandroidcongressodeti.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner                 = this
        binding.selectContactViewPager.adapter = getContactViewPagerAdapter()
    }

    private fun getContactViewPagerAdapter(): PagerAdapter {
        val pagerAdapter = CustomPagerAdapter(supportFragmentManager)

        pagerAdapter.addPage(
            PageFragment(
                pageTitle = getString(R.string.main_contact_page_fragment_title),
                content = ContactFragment()
            )
        )

        pagerAdapter.addPage(
            PageFragment(
                pageTitle = getString(R.string.main_favorite_contact_page_fragment_title),
                content = FavoriteContactFragment()
            )
        )

        return pagerAdapter
    }


}
