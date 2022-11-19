package com.kunal.wikipedia.view.pagelist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kunal.wikipedia.R
import com.kunal.wikipedia.data.base.Response
import com.kunal.wikipedia.data.pagelist.model.Page
import com.kunal.wikipedia.view.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_page_list.view.*

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [PageListFragment.OnPageListInteractionListener] interface.
 */
class PageListFragment : BaseFragment(), PageListAdapter.OnPageSelectedListener {

    private var listener: OnPageListInteractionListener? = null

    private val pageListAdapter = PageListAdapter(this@PageListFragment)

    private val pageListViewModel by viewModels<PageListViewModel> { viewModelFactory }
    //private val pageListViewModel by activityViewModels<PageListViewModel>()


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
        view.search.setOnClickListener {
            showLoader()
            pageListViewModel.search(view.text.text.toString())
        }
    }

    override fun onStart() {
        super.onStart()
        pageListViewModel.pageList.observe(this) {
            it?.let {
                hideLoader()
                pageListAdapter.contentList = it
            }
        }

        pageListViewModel.error.observe(this) {
            it?.let {
                hideLoader()
                showError(it.toString())

            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
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
