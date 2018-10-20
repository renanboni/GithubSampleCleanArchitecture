package com.example.cache.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.cache.db.ProjectsConstants

@Entity(tableName = ProjectsConstants.TABLE_NAME)
data class CachedProject (

        @PrimaryKey
        @ColumnInfo(name = ProjectsConstants.COLUMN_PROJECT_ID)
        var id: String,
        var name: String,
        var fullName: String,
        var starCount: String,
        var dateCreated: String,
        var ownerName: String,
        var ownerAvatar: String,

        @ColumnInfo(name = ProjectsConstants.COLUMN_IS_BOOKMARKED)
        val isBookmarked: Boolean
)
