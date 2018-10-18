package com.boni.clean.data.repository

import com.boni.clean.data.model.ProjectEntity
import io.reactivex.Observable

interface ProjectsRemote {
    fun getProjects() : Observable<List<ProjectEntity>>
}