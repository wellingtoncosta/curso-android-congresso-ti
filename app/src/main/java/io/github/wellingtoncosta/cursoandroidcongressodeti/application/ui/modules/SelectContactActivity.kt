package io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import io.github.wellingtoncosta.cursoandroidcongressodeti.R
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.selectcontact.SelectContactFragment
import io.github.wellingtoncosta.cursoandroidcongressodeti.databinding.SelectContactActivityBinding

class SelectContactActivity : AppCompatActivity() {

    private lateinit var mBinding: SelectContactActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = setContentView(this, R.layout.select_contact_activity)

        val pagerAdapter = CustomPagerAdapter(supportFragmentManager)
        mBinding.selectContactViewPager.adapter = pagerAdapter
    }

    private inner class CustomPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getCount(): Int = 2

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> SelectContactFragment()
                1 -> SelectContactFragment()
                else -> throw Exception()
            }
        }
    }

}
