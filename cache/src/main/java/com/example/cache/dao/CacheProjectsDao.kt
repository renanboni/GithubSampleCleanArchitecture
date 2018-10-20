package com.example.cache.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.cache.db.ProjectsConstants
import com.example.cache.db.ProjectsConstants.DELETE_PROJECTS
import com.example.cache.db.ProjectsConstants.QUERY_BOOKMARKED_PROJECTS
import com.example.cache.db.ProjectsConstants.QUERY_PROJECTS
import com.example.cache.db.ProjectsConstants.QUERY_UPDATE_BOOKMARK_STATUS
import com.example.cache.model.CachedProject
import io.reactivex.Flowable

@Dao
abstract class CacheProjectsDao {

    @Query(QUERY_PROJECTS)
    abstract fun getProjects(): Flowable<List<CachedProject>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertProjects(projects: List<CachedProject>)

    @Query(DELETE_PROJECTS)
    abstract fun deleteProjects()

    @Query(QUERY_BOOKMARKED_PROJECTS)
    abstract fun getBookmarkedProjects(): Flowable<List<CachedProject>>

    @Query(QUERY_UPDATE_BOOKMARK_STATUS)
    abstract fun setBookmarkStatus(isBookmarked: Boolean, projectId: String)
}