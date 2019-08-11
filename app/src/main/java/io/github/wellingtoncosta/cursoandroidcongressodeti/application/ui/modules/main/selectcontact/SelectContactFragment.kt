package io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.main.selectcontact

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import io.github.wellingtoncosta.cursoandroidcongressodeti.R
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.favoritecontact.FavoriteContactActivity
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.main.selectcontact.adapters.ContactAdapter
import io.github.wellingtoncosta.cursoandroidcongressodeti.databinding.FragmentSelectContactBinding
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.models.contact.Contact

abstract class SelectContactFragment : Fragment() {

    private lateinit var mSelectContactFragmentBinding: FragmentSelectContactBinding

    private val mContactAdapter =
        ContactAdapter(::startFavoriteContactScreen)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mSelectContactFragmentBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.fragment_select_contact, container, false)

        return mSelectContactFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mSelectContactFragmentBinding.selectContactRecyclerView.adapter = mContactAdapter

        configureSwipeRefresh()
    }

    private fun configureSwipeRefresh() {
        mSelectContactFragmentBinding.selectContactSwipeRefreshLayout.setOnRefreshListener {
            requestData()
        }
    }

    override fun onStart() {
        super.onStart()

        configureViewModelObservers()

        requestData()
    }

    abstract fun configureViewModelObservers()

    abstract fun requestData()

    private fun startFavoriteContactScreen(contactId: Int) {
        val intent = Intent(activity, FavoriteContactActivity::class.java)
    }

    internal fun setContactAdapterData(contacts: List<Contact>) {
        mContactAdapter.addData(contacts)
    }

    internal fun showLoading() {
        mSelectContactFragmentBinding.selectContactSwipeRefreshLayout.isRefreshing = true
    }

    internal fun hideLoading() {
        mSelectContactFragmentBinding.selectContactSwipeRefreshLayout.isRefreshing = false
    }

    internal fun showErrorMessage(message: String?) {
        Toast.makeText(context, message, LENGTH_LONG).show()
    }


}