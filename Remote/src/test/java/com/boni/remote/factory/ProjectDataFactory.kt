package com.boni.remote.factory

import com.boni.clean.data.model.ProjectEntity
import com.boni.remote.model.OwnerModel
import com.boni.remote.model.ProjectModel
import com.boni.remote.model.ProjectsResponseModel

object ProjectDataFactory {

    fun makeOwner(): OwnerModel {
        return OwnerModel(DataFactory.randomString(), DataFactory.randomString())
    }

    fun makeProject(): ProjectModel {
        return ProjectModel(DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomString(), DataFactory.randomInt(),
                DataFactory.randomString(), makeOwner())
    }

    fun makeProjectEntity(): ProjectEntity {
        return ProjectEntity(DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomString(), DataFactory.randomString(),
                DataFactory.randomString())
    }

    fun makeProjectsResponse(): ProjectsResponseModel {
        return ProjectsResponseModel(listOf(makeProject(), makeProject()))
    }

}