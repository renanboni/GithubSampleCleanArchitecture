package com.boni.clean.interactor.bookmark

import com.boni.clean.domain.executor.PostExecutionThread
import com.boni.clean.domain.interactor.bookmark.GetBookmarkedProjects
import com.boni.clean.domain.model.Project
import com.boni.clean.domain.repository.ProjectsRepository
import com.boni.clean.test.ProductDataFactory
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetBookmarkedProjectsTest {

    @Mock
    lateinit var postExecutionThread: PostExecutionThread

    @Mock
    lateinit var projectsRepository: ProjectsRepository

    private lateinit var getBookmarkedProjects: GetBookmarkedProjects

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getBookmarkedProjects = GetBookmarkedProjects(projectsRepository, postExecutionThread)
    }

    @Test
    fun getBookmarkedProjectsCompletes() {
        stubGetProjects(Observable.just(ProductDataFactory.makeProjectList(2)))
        val testObserver = getBookmarkedProjects.buildUseCaseObservable().test()
        testObserver.assertComplete()
    }

    @Test
    fun getBookmarkedProjectsReturnsData() {
        val projects = ProductDataFactory.makeProjectList(2)
        stubGetProjects(Observable.just(projects))
        val testObserver = getBookmarkedProjects.buildUseCaseObservable().test()
        testObserver.assertValue(projects)
    }

    private fun stubGetProjects(observable: Observable<List<Project>>) {
        whenever(projectsRepository.getBookmarkedProjects()).thenReturn(observable)
    }
}