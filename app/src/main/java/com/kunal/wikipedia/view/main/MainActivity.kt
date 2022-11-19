package com.kunal.wikipedia.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kunal.wikipedia.R
import com.kunal.wikipedia.data.pagelist.model.Page
import com.kunal.wikipedia.view.base.BaseFragment
import com.kunal.wikipedia.view.pagelist.PageListFragment

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
}
