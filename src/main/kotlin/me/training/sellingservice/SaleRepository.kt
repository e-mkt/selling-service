package me.training.sellingservice

import org.springframework.stereotype.Repository
import java.math.BigDecimal
import java.util.UUID

@Repository
class SaleRepository : IRepository {
    override fun findByIds(ids: List<UUID>): List<Sale> = listOf(Sale(
                id= ids.first(),
                items = listOf(Item("PROD001")),
                totalAmount = BigDecimal("12000.00"),
                confirmed = false
        ))
}