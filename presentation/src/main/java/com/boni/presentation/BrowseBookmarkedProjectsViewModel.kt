package com.boni.presentation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.boni.clean.domain.interactor.bookmark.GetBookmarkedProjects
import com.boni.clean.domain.model.Project
import com.boni.presentation.mapper.ProjectViewMapper
import com.boni.presentation.model.ProjectView
import com.boni.presentation.state.Resource
import com.boni.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class BrowseBookmarkedProjectsViewModel @Inject constructor(
    private val getBookmarkedProjects: GetBookmarkedProjects,
    private val mapper: ProjectViewMapper) : ViewModel() {

    private val liveData: MutableLiveData<Resource<List<ProjectView>>> = MutableLiveData()

    override fun onCleared() {
        getBookmarkedProjects.dispose()
        super.onCleared()
    }

    fun getProjects() : LiveData<Resource<List<ProjectView>>> {
        return liveData
    }

    fun fetchProjects() {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        return getBookmarkedProjects.execute(ProjectsSubscriber())
    }

    inner class ProjectsSubscriber: DisposableObserver<List<Project>>() {
        override fun onComplete() { }

        override fun onNext(t: List<Project>) {
            liveData.postValue(Resource(ResourceState.SUCCESS, t.map { mapper.mapToView(it) }, null))
        }

        override fun onError(e: Throwable) {
            liveData.postValue(Resource(ResourceState.ERROR, null, e.localizedMessage))
        }
    }
}