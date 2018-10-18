package com.boni.clean.test

import com.boni.clean.domain.model.Project
import java.util.*

object ProductDataFactory {

    fun randomUuid() : String {
        return UUID.randomUUID().toString()
    }

    fun randomBoolean(): Boolean {
        return Math.random() < 0.5
    }

    fun makeProject() : Project {
        return Project(randomUuid(), randomUuid(), randomUuid(),
                randomUuid(), randomUuid(), randomUuid(),
                randomUuid(), randomBoolean())
    }

    fun makeProjectList(count: Int): MutableList<Project> {
        val projects = mutableListOf<Project>()
        repeat(count) {
            projects.add(makeProject())
        }
        return projects
    }
}