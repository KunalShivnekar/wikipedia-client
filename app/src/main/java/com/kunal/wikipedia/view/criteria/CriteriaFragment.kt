package com.kunal.wikipedia.view.criteria

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.kunal.wikipedia.R
import com.kunal.wikipedia.view.base.BaseFragment
import com.kunal.wikipedia.view.criteria.model.CriteriaVariable

import kotlinx.android.synthetic.main.fragment_criteria.view.criteria_list
import kotlinx.android.synthetic.main.fragment_criteria.view.scan_name
import kotlinx.android.synthetic.main.fragment_criteria.view.scan_tag

private const val ARG_SCAN = "ARG_SCAN"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CriteriaFragment.OnCriteriaInteractionListener] interface
 * to handle interaction events.
 * Use the [CriteriaFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class CriteriaFragment : BaseFragment<CriteriaContract.Presenter>(), CriteriaContract.View, CriteriaAdapter.OnVariableSelectedListener {

    private var listener: OnCriteriaInteractionListener? = null

    private val criteriaAdapter = CriteriaAdapter(this)



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_criteria, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.criteria_list as RecyclerView

        with(recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = criteriaAdapter
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
        presenter.attachView(this,this)
        if (context is OnCriteriaInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnCriteriaInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onVariableSelected(criteria: CriteriaVariable) {
        listener?.onVariableSelected(criteria)
    }




    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnCriteriaInteractionListener {
        fun onVariableSelected(criteria: CriteriaVariable)
    }

    companion object {
        @JvmStatic
        fun newInstance() = CriteriaFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }
}
