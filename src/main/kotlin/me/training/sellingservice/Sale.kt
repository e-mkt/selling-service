package me.training.sellingservice

import java.math.BigDecimal
import java.util.UUID

data class Item(val code: String)

data class Sale (
    val id: UUID,
    val items: List<Item>,
    val totalAmount: BigDecimal,
    private var confirmed: Boolean
) {
    fun confirm() {
        if (!confirmed) {
            this.confirmed = true
        } else {
            throw Exception("Sale with ID $id already confirmed.")
        }
    }
}