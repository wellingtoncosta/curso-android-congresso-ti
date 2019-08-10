package io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.adapters.pageadapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class CustomPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val pages = mutableListOf<PageFragment>()

    override fun getCount(): Int = pages.size

    override fun getItem(position: Int): Fragment {
        return pages[position].content
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return pages[position].pageTitle
    }

    fun addPage(pageFragment: PageFragment) {
        pages.add(pageFragment)
    }


}