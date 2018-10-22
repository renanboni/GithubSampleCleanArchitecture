package com.boni.clean.mobile_ui.browse

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.boni.clean.mobile_ui.model.Project
import javax.inject.Inject

class BrowseAdapter @Inject constructor() : RecyclerView.Adapter<BrowseAdapter.ViewHolder>(){

    var projects = arrayListOf<Project>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_project, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = projects.count()

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val project = projects[position]
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val avatarImage: ImageView
        val ownerNameText: TextView
        val projectNameText: TextView
        val bookmarkProject: TextView

        init {
            avatarImage = view.findViewById(R.id.image_owner_avatar)

        }
    }
}