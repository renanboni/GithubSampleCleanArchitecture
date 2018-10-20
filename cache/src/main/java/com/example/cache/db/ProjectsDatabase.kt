package com.example.cache.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.cache.dao.CacheProjectsDao
import com.example.cache.dao.ConfigDao
import com.example.cache.model.CachedProject
import com.example.cache.model.Config
import javax.inject.Inject

@Database(entities = [CachedProject::class, Config::class], version = 1)
abstract class ProjectsDatabase @Inject constructor() : RoomDatabase() {

    abstract fun cachedProjectsDao(): CacheProjectsDao
    abstract fun configDao(): ConfigDao

    private var INSTANCE: ProjectsDatabase? = null
    private val lock = Any()

    fun getInstance(context: Context): ProjectsDatabase {
        if(INSTANCE == null) {
            synchronized(lock) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, ProjectsDatabase::class.java,
                        "projects.db").build()

            }
        }
        return INSTANCE as ProjectsDatabase
    }
}