package com.boni.clean.mobile_ui.mapper

import com.boni.clean.mobile_ui.factory.ProjectFactory
import org.junit.Test
import kotlin.test.assertEquals

class ProjectMapperTest {

    private val mapper = ProjectViewMapper()

    @Test
    fun mapToviewMapsData() {
        val project = ProjectFactory.makeProjectView()
        val projectForUi = mapper.mapToView(project)

        assertEquals(project.id, projectForUi.id)
        assertEquals(project.name, projectForUi.name)
        assertEquals(project.fullName, projectForUi.fullName)
        assertEquals(project.starCount, projectForUi.starCount)
        assertEquals(project.dateCreated, projectForUi.dateCreated)
        assertEquals(project.ownerName, projectForUi.ownerName)
        assertEquals(project.ownerAvatar, projectForUi.ownerAvatar)
        assertEquals(project.isBookmarked, projectForUi.isBookmarked)
    }
}