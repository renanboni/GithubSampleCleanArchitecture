package com.boni.clean.mapper

import com.boni.clean.data.mapper.ProjectMapper
import com.boni.clean.data.model.ProjectEntity
import com.boni.clean.domain.model.Project
import com.boni.clean.factory.ProjectFactory
import org.junit.Test
import kotlin.test.assertEquals

class ProjectMapperTest {

    private val mapper = ProjectMapper()

    @Test
    fun mapsFromEntity() {
        val entity = ProjectFactory.makeProjectEntity()
        val model = mapper.mapFromEntity(entity)

        assertEqualData(entity, model)
    }

    @Test
    fun mapsToEntity() {
        val model = ProjectFactory.makeProject()
        val entity = mapper.mapToEntity(model)

        assertEqualData(entity, model)
    }

    private fun assertEqualData(entity: ProjectEntity, model: Project) {
        assertEquals(entity.id, model.id)
        assertEquals(entity.dateCreated, model.dateCreated)
        assertEquals(entity.fullName, model.fullName)
        assertEquals(entity.ownerAvatar, model.ownerAvatar)
        assertEquals(entity.ownerName, model.ownerName)
        assertEquals(entity.starCount, model.starCount)
        assertEquals(entity.isBookmarked, model.isBookmarked)
        assertEquals(entity.name, model.name)
    }
}