package me.training.sellingservice

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.net.URI
import java.util.UUID

@RestController
@RequestMapping("/sales")
class SaleController(
    val service: SaleService
) {
    @PostMapping("/confirm")
    fun confirm(@RequestBody confirmSalesDTO: ConfirmSalesDTO) {
        service.confirm(confirmSalesDTO.ids)
        ResponseEntity.accepted()
    }

    @PostMapping
    fun create(@RequestBody createSaleDTO: CreateSaleDTO): ResponseEntity<Sale> {
        val sale = Sale(
            id = UUID.randomUUID(),
            items = listOf(Item("COD001")),
            totalAmount = createSaleDTO.totalAmount,
            confirmed = false
        )
        return ResponseEntity
            .created(URI("http://api-dev.com.br/selling-service/sales/${sale.id}"))
            .body(sale)
    }

}

data class ConfirmSalesDTO(
    val ids: List<UUID>
)

data class CreateSaleDTO(
    val totalAmount: BigDecimal
)
