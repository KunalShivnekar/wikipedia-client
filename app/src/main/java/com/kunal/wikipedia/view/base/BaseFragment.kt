package com.kunal.wikipedia.view.base

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider
import com.kunal.wikipedia.config.WikipediaApplication
import com.kunal.wikipedia.di.components.ViewComponent
import javax.inject.Inject

/**
 * Created by kunal.
 */
abstract class BaseFragment:Fragment(),BaseView {

    private lateinit var progressDialog: ProgressDialog
    protected lateinit var injector: ViewComponent
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity?.let {
            injector =
                (it.application as WikipediaApplication).dataComponent.viewComponentBuilder.build()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressDialog = ProgressDialog(context)
        with(progressDialog) {
            setCancelable(false)
            setMessage("Loading..")
        }
    }

    override fun showError(error: String) {
        showToast(error)
    }

    /**
     * Use this method to show progress bar on the view
     */
    override fun showLoader() {
        progressDialog.show()
    }

    /**
     * Use this method to hide progress bar on the view
     */
    override fun hideLoader() {
        progressDialog.hide()
    }

    private fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}