package io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.components.contactcardview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import io.github.wellingtoncosta.cursoandroidcongressodeti.R
import io.github.wellingtoncosta.cursoandroidcongressodeti.application.ui.components.contactcardview.domain.dtos.ContactDto
import io.github.wellingtoncosta.cursoandroidcongressodeti.databinding.ContactCardViewComponentBinding

class ContactCardView : FrameLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val mBinding: ContactCardViewComponentBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.contact_card_view_component,
        this,
        true
    )

    init {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }

    fun setContactDto(contactDto: ContactDto) {
        mBinding.contactDto = contactDto
    }


}