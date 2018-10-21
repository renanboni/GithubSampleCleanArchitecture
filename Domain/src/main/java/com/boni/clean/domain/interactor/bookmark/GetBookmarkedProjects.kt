package com.boni.clean.domain.interactor.bookmark

import com.boni.clean.domain.executor.PostExecutionThread
import com.boni.clean.domain.interactor.ObservableUseCase
import com.boni.clean.domain.model.Project
import com.boni.clean.domain.repository.ProjectsRepository
import io.reactivex.Observable
import javax.inject.Inject

open class GetBookmarkedProjects @Inject constructor(private val projectsRepository: ProjectsRepository,
                                                postExecutionThread: PostExecutionThread)
    : ObservableUseCase<List<Project>, Nothing?>(postExecutionThread) {

    public override fun buildUseCaseObservable(params: Nothing?): Observable<List<Project>> {
        return projectsRepository.getBookmarkedProjects()
    }
}