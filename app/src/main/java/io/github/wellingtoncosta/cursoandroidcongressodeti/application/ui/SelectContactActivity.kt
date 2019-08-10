package io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import io.github.wellingtoncosta.cursoandroidcongressodeti.R
import io.github.wellingtoncosta.cursoandroidcongressodeti.databinding.SelectContactActivityBinding

class SelectContactActivity : AppCompatActivity() {

    private lateinit var mBinding: SelectContactActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = setContentView(this, R.layout.select_contact_activity)
    }


}
