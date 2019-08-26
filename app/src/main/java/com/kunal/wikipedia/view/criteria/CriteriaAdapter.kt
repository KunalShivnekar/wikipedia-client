package com.kunal.wikipedia.view.criteria

import android.text.Spannable
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kunal.wikipedia.R
import com.kunal.wikipedia.view.criteria.model.Criteria
import com.kunal.wikipedia.view.criteria.model.CriteriaPlainText
import com.kunal.wikipedia.view.criteria.model.CriteriaVariable

/**
 * Created by kunal on 2019-07-28.
 */
class CriteriaAdapter(private val listener: OnVariableSelectedListener) : RecyclerView.Adapter<CriteriaAdapter.CriteriaViewHolder>() {

    var contentList = mutableListOf<Criteria>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CriteriaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.page_item, parent, false)
        return CriteriaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CriteriaViewHolder, position: Int) {
        holder.item = contentList[position]
    }

    override fun getItemCount(): Int = contentList.size

    inner class CriteriaViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var item: Criteria? = null
            set(value) {
                field = value

            }
    }


    interface OnVariableSelectedListener {
        fun onVariableSelected(criteria: CriteriaVariable)
    }
}