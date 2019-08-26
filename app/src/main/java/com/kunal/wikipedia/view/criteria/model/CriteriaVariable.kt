package com.kunal.wikipedia.view.criteria.model

import com.kunal.wikipedia.view.pagelist.model.Page

import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

/**
 * Created by kunal.
 */
@Parcelize
data class CriteriaVariable(
    val text:String,
    val variableMap: @RawValue MutableMap<String,Page>
):Criteria {

    override val type: String = "variable"
}