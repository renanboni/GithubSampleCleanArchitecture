package com.boni.clean.data.store

import com.boni.clean.data.repository.ProjectsDataStore
import javax.inject.Inject

open class ProjectDataStoreFactory @Inject constructor(
        private val projectsCacheDataStore: ProjectsCacheDataStore,
        private val projectsRemoteDataStore: ProjectsRemoteDataStore
) {
    open fun getDataStore(projectsCached: Boolean, cacheExpired: Boolean): ProjectsDataStore {
        return if (projectsCached && !cacheExpired) {
            projectsCacheDataStore
        } else {
            projectsRemoteDataStore
        }
    }

    open fun getCacheDataStore() : ProjectsDataStore {
        return projectsCacheDataStore
    }
}