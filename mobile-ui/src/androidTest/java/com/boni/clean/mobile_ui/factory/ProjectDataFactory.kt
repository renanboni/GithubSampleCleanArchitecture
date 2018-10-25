package com.boni.clean.mobile_ui.factory

import com.boni.clean.domain.model.Project

object ProjectDataFactory {

    fun makeProject(): Project {
        return Project(TestDataFactory.randomUuid(), TestDataFactory.randomUuid(),
                TestDataFactory.randomUuid(), TestDataFactory.randomUuid(), TestDataFactory.randomUuid(),
                TestDataFactory.randomUuid(), TestDataFactory.randomUuid(), TestDataFactory.randomBoolean())
    }

}