package com.boni.presentation.mapper

import com.boni.presentation.factory.ProjectFactory
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import junit.framework.Assert.assertEquals

@RunWith(JUnit4::class)
class MapperTest {

    private val mapper = ProjectViewMapper()

    @Test
    fun mapToViewMapsData() {
        val project = ProjectFactory.makeProject()
        val projectView = mapper.mapToView(project)

        assertEquals(project.id, projectView.id)
        assertEquals(project.name, projectView.name)
        assertEquals(project.fullName, projectView.fullName)
        assertEquals(project.starCount, projectView.starCount)
        assertEquals(project.dateCreated, projectView.dateCreated)
        assertEquals(project.ownerAvatar, projectView.ownerAvatar)
        assertEquals(project.ownerName, projectView.ownerName)
        assertEquals(project.isBookmarked, projectView.isBookmarked)
    }
}