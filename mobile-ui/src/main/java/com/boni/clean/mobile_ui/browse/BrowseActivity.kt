package com.boni.clean.mobile_ui.browse

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.boni.clean.mobile_ui.R
import kotlinx.android.synthetic.main.activity_browse.*

class BrowseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)

        setupBrowseProjects()
    }

    private fun setupBrowseProjects() {
        recycler_projects.layoutManager = LinearLayoutManager(this)
    }
}
