package me.training.sellingservice

import java.util.UUID

interface IRepository {
    fun findByIds(ids: List<UUID>): List<Sale>
}