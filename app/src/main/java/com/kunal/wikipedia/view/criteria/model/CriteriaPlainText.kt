package com.kunal.wikipedia.view.criteria.model

import kotlinx.android.parcel.Parcelize

/**
 * Created by kunal.
 */
@Parcelize
data class CriteriaPlainText(val text:String):Criteria {

    override val type: String = "plain_text"
}