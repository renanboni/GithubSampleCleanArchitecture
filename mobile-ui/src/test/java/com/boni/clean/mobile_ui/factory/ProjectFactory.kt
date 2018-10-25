package com.boni.clean.mobile_ui.factory

import com.boni.presentation.model.ProjectView

object ProjectFactory {
    fun makeProjectView(): ProjectView {
        return ProjectView(DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid(),
                DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomBoolean())
    }
}