package com.kunal.wikipedia.view.pagelist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kunal.wikipedia.R
import com.kunal.wikipedia.view.pagelist.model.Page
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.page_item.view.*


class PageListAdapter(private val listener: OnPageSelectedListener) : RecyclerView.Adapter<PageListAdapter.PageViewHolder>() {

    var contentList = listOf<Page>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.page_item, parent, false)
        return PageViewHolder(view)
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        holder.item = contentList[position]
    }

    override fun getItemCount(): Int = contentList.size

    inner class PageViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
         var item:Page? = null
            set(value) {
                if(value == null) return
                field = value
                view.page_name.text = value.title
                view.page_content.text = value.terms.description[0]
                if(value.thumbnail != null)
                    Picasso.get().load(value.thumbnail.source).into(view.page_image)
            }

        init {
            view.setOnClickListener { listener.onPageSelected(item!!) }
        }
    }

    interface OnPageSelectedListener {
        fun onPageSelected(page:Page)
    }
}
