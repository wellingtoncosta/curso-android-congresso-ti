package io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.selectcontact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import io.github.wellingtoncosta.cursoandroidcongressodeti.R
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.modules.selectcontact.adapters.ContactAdapter
import io.github.wellingtoncosta.cursoandroidcongressodeti.databinding.SelectContactFragmentBinding
import io.github.wellingtoncosta.cursoandroidcongressodeti.domain.models.contact.Contact

abstract class SelectContactFragment : Fragment() {

    private lateinit var mSelectContactFragmentBinding: SelectContactFragmentBinding

    private val mContactAdapter = ContactAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mSelectContactFragmentBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.select_contact_fragment, container, false)

        return mSelectContactFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mSelectContactFragmentBinding.selectContactRecyclerView.adapter = mContactAdapter
    }

    override fun onStart() {
        super.onStart()

        configureViewModelObservers()

        requestData()
    }

    abstract fun configureViewModelObservers()

    abstract fun requestData()

    fun setContactAdapterData(contacts: List<Contact>) {
        mContactAdapter.addData(contacts)
    }


}