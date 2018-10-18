package com.boni.clean.data.repository

import com.boni.clean.data.model.ProjectEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface ProjectsCache {
    fun clearProjects() : Completable

    fun saveProjects(projects: List<ProjectEntity>) : Completable

    fun getProjects() : Observable<List<ProjectEntity>>

    fun getBookmarkedProjects() : Observable<List<ProjectEntity>>

    fun setProjectAsBookmarked(projectId: String) : Completable

    fun setProjectAsNotBookmarked(projectId: String) : Completable

    fun areProjectsCached() : Single<Boolean>

    fun setLastCacheTime(lastCache: Long) : Completable

    fun isProjectCacheExpired() : Single<Boolean>
}