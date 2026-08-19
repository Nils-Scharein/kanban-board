package dev.nils.backend.controller

import dev.nils.backend.dto.response.CardDTO
import dev.nils.backend.service.CardService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/card")
class CardController(
    val cardService: CardService,
) {
    @GetMapping("/{id}")
    fun getCardById(
        @PathVariable id: Long,
    ): CardDTO = cardService.getById(id)
}
