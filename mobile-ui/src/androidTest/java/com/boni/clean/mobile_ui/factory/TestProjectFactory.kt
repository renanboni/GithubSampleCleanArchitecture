package com.boni.clean.mobile_ui.factory

import com.boni.presentation.model.ProjectView

object TestProjectFactory {
    fun makeProjectView(): ProjectView {
        return ProjectView(TestDataFactory.randomUuid(), TestDataFactory.randomUuid(),
                TestDataFactory.randomUuid(), TestDataFactory.randomUuid(), TestDataFactory.randomUuid(),
                TestDataFactory.randomUuid(), TestDataFactory.randomUuid(), TestDataFactory.randomBoolean())
    }
}