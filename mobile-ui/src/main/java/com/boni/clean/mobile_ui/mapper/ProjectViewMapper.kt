package com.boni.clean.mobile_ui.mapper

import com.boni.clean.mobile_ui.model.Project
import com.boni.presentation.model.ProjectView
import javax.inject.Inject

class ProjectViewMapper @Inject() constructor() : ViewMapper<ProjectView, Project> {
    override fun mapToView(presentation: ProjectView): Project {
        return Project(presentation.id, presentation.name,
                presentation.fullName, presentation.starCount,
                presentation.dateCreated, presentation.ownerName,
                presentation.ownerAvatar, presentation.isBookmarked)
    }
}