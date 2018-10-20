package com.example.cache.model

import android.arch.persistence.room.Entity
import com.example.cache.db.ConfigConstants

@Entity(tableName = ConfigConstants.TABLE_NAME)
class Config(val lastCacheTime: Long)