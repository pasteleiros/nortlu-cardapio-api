package com.nortlu.service

import io.lettuce.core.api.StatefulRedisConnection
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RedisServer() {

    @Inject
    private lateinit var connection: StatefulRedisConnection<String, String>;

    private fun getConnection() = connection.sync()

    fun salvarCache(key: String, value: String) = getConnection().set(key, value)

    fun setarExpiracao(key: String, segundos: Long) = getConnection().expire(key, segundos)

    fun salvarCache(key: String, value: String, segundos: Long) {
        salvarCache(key, value)
        setarExpiracao(key, segundos)
    }

    fun salvaLsCache(dadosRedis: List<DadosRedis>, segundos: Long) {
        dadosRedis.forEach {
            salvarCache(it.key, it.value)
            setarExpiracao(it.key, segundos)
        }
    }
}

class DadosRedis(val key: String, val value: String)