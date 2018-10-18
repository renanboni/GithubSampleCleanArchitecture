package com.boni.clean.data

import com.boni.clean.data.mapper.ProjectMapper
import com.boni.clean.data.repository.ProjectsCache
import com.boni.clean.data.repository.ProjectsDataStore
import com.boni.clean.data.store.ProjectDataStoreFactory
import com.boni.clean.domain.model.Project
import com.boni.clean.domain.repository.ProjectsRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class ProjectsDataRepository @Inject constructor(
        private val mapper: ProjectMapper,
        private val cache: ProjectsCache,
        private val factory: ProjectDataStoreFactory
) : ProjectsRepository {

    override fun getProjects(): Observable<List<Project>> {
        return Observable.zip(cache.areProjectsCached().toObservable(), cache.isProjectCacheExpired().toObservable(),
                BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>>{
                    areCached, isExpired -> Pair(areCached, isExpired)
                }).flatMap { factory.getDataStore(it.first, it.second).getProjects() }
                .flatMap { projects ->
                    factory.getCacheDataStore()
                            .saveProjects(projects)
                            .andThen(Observable.just(projects))
                }.map {
                    it.map {
                        mapper.mapFromEntity(it)
                    }
                }
    }

    override fun bookmarkProject(projectId: String): Completable {
        return factory.getCacheDataStore().setProjectAsBookmarked(projectId)
    }

    override fun unbookmarkProject(projectId: String): Completable {
        return factory.getCacheDataStore().setProjectAsNotBookmarked(projectId)
    }

    override fun getBookmarkedProjects(): Observable<List<Project>> {
        return factory.getCacheDataStore().getBookmarkedProjects()
                .map {
                    it.map { mapper.mapFromEntity(it) }
                }
    }
}