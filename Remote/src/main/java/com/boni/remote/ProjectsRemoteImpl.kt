package com.boni.remote

import com.boni.clean.data.model.ProjectEntity
import com.boni.clean.data.repository.ProjectsRemote
import com.boni.remote.mapper.ProjectsResponseModelMapper
import com.boni.remote.service.GithubTrendingService
import io.reactivex.Observable
import javax.inject.Inject

class ProjectsRemoteImpl @Inject constructor(
        private val service: GithubTrendingService,
        private val mapper: ProjectsResponseModelMapper
) : ProjectsRemote {

    override fun getProjects(): Observable<List<ProjectEntity>> {
        return service.searchRepositories("language:kotlin", "stars", "desc")
                .map { it.items.map { mapper.mapFromModel(it) } }
    }
}