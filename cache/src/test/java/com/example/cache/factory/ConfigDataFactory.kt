package com.example.cache.factory

import com.example.cache.model.Config

object ConfigDataFactory {

    fun makeCachedConfig(): Config {
        return Config(lastCacheTime = DataFactory.randomLong())
    }
}