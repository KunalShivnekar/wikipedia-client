package com.kunal.wikipedia.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kunal.wikipedia.R
import com.kunal.wikipedia.view.base.BaseFragment
import com.kunal.wikipedia.view.pagelist.PageListFragment
import com.kunal.wikipedia.view.pagelist.model.Page

class MainActivity : AppCompatActivity(), PageListFragment.OnPageListInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.root, PageListFragment.newInstance())
            .commit()
    }

    override fun onPageSelected(page: Page) {

    }

    private fun addFragmentToBackStack(fragment: BaseFragment<*>){
        supportFragmentManager.beginTransaction()
            .replace(R.id.root, fragment)
            .addToBackStack(null)
            .commit()
    }
}
