package com.boni.clean.interactor.browse

import com.boni.clean.domain.executor.PostExecutionThread
import com.boni.clean.domain.interactor.browse.GetProjects
import com.boni.clean.domain.model.Project
import com.boni.clean.domain.repository.ProjectsRepository
import com.boni.clean.test.ProductDataFactory
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetProjectsTest {

    @Mock
    lateinit var projectsRepository : ProjectsRepository

    @Mock
    lateinit var postExecutionThread: PostExecutionThread

    private lateinit var getProjects : GetProjects

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getProjects = GetProjects(projectsRepository, postExecutionThread)
    }

    @Test
    fun getProjectsCompletes() {
        stubGetProjects(Observable.just(ProductDataFactory.makeProjectList(2)))
        val testObserver = getProjects.buildUseCaseObservable().test()
        testObserver.assertComplete()
    }

    @Test
    fun getProjectsReturnsData() {
        val projects = ProductDataFactory.makeProjectList(2)
        stubGetProjects(Observable.just(projects))
        val testObserver = getProjects.buildUseCaseObservable().test()
        testObserver.assertValue(projects)
    }

    private fun stubGetProjects(observable: Observable<List<Project>>) {
        whenever(projectsRepository.getProjects()).thenReturn(observable)
    }
}