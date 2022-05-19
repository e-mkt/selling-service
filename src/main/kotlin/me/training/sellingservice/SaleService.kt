package me.training.sellingservice

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SaleService(
    val repository: SaleRepository
) {
    fun confirm(saleIds: List<UUID>) {
        repository.findByIds(saleIds).also { sales ->
                sales.forEach {
                    it.confirm()
            }
        }
    }
}
