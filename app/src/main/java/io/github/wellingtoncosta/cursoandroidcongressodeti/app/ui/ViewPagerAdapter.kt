package io.github.wellingtoncosta.cursoandroidcongressodeti.app.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    private val pages = mutableListOf<FragmentPage>()

    override fun getItem(position: Int): Fragment {
        return pages[position].fragment
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return pages[position].title
    }

    fun addPage(page: FragmentPage) {
        pages.add(page)
    }

}

data class FragmentPage(val fragment: Fragment, val title: String)
