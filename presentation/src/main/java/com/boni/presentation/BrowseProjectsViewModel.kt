package com.boni.presentation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.boni.clean.domain.interactor.bookmark.BookmarkProject
import com.boni.clean.domain.interactor.bookmark.UnbookmarkProject
import com.boni.clean.domain.interactor.browse.GetProjects
import com.boni.clean.domain.model.Project
import com.boni.presentation.mapper.ProjectViewMapper
import com.boni.presentation.model.ProjectView
import com.boni.presentation.state.Resource
import com.boni.presentation.state.ResourceState
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class BrowseProjectsViewModel @Inject constructor(
        private val getProjects: GetProjects,
        private val bookmarkProject: BookmarkProject,
        private val unbookmarkProject: UnbookmarkProject,
        private val mapper: ProjectViewMapper) : ViewModel() {

    private val liveData: MutableLiveData<Resource<List<ProjectView>>> = MutableLiveData()

    override fun onCleared() {
        getProjects.dispose()
        super.onCleared()
    }

    fun getProjects() : LiveData<Resource<List<ProjectView>>> {
        return liveData
    }

    fun bookmarkProject(projectId: String) {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        return bookmarkProject.execute(BookmarkProjectsSubscriber(),
                BookmarkProject.Params.forProject(projectId))
    }

    fun unbookmarkProject(projectId: String) {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        return unbookmarkProject.execute(BookmarkProjectsSubscriber(),
                UnbookmarkProject.Params.forProject(projectId))
    }

    fun fetchProjects() {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        return getProjects.execute(ProjectsSubscriber())
    }

    inner class ProjectsSubscriber: DisposableObserver<List<Project>>() {
        override fun onComplete() { }

        override fun onNext(t: List<Project>) {
            liveData.postValue(Resource(ResourceState.SUCCESS,
                    t.map { mapper.mapToView(it) }, null))
        }

        override fun onError(e: Throwable) {
            liveData.postValue(Resource(ResourceState.ERROR, null, e.localizedMessage))
        }
    }

    inner class BookmarkProjectsSubscriber: DisposableCompletableObserver() {
        override fun onComplete() {
            liveData.postValue(Resource(ResourceState.SUCCESS, liveData.value?.data, null))
        }

        override fun onError(e: Throwable) {
            liveData.postValue(Resource(ResourceState.ERROR, null, e.localizedMessage))
        }
    }
}