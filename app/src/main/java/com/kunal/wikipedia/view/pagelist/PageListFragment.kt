package com.kunal.wikipedia.view.pagelist

import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kunal.wikipedia.R
import com.kunal.wikipedia.view.base.BaseFragment
import com.kunal.wikipedia.view.pagelist.model.Page
import kotlinx.android.synthetic.main.fragment_page_list.view.*

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [PageListFragment.OnPageListInteractionListener] interface.
 */
class PageListFragment : BaseFragment<PageListContract.Presenter>(), PageListContract.View, PageListAdapter.OnPageSelectedListener {

    private var listener: OnPageListInteractionListener? = null

    private val pageListAdapter = PageListAdapter(this@PageListFragment)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_page_list, container, false)
        with(view.list) {
            layoutManager = LinearLayoutManager(context)
            adapter = pageListAdapter
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.search.setOnClickListener { presenter.search(view.text.text.toString()) }
    }

    override fun setData(list: List<Page>) {
        pageListAdapter.contentList = list
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
        presenter.attachView(this,this)
        if (context is OnPageListInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnPageListInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onPageSelected(page: Page) {
        listener?.onPageSelected(page)
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    interface OnPageListInteractionListener {
        fun onPageSelected(page:Page)
    }

    companion object {
        @JvmStatic
        fun newInstance() = PageListFragment()
    }
}
