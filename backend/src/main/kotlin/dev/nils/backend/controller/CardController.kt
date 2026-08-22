package dev.nils.backend.controller

import dev.nils.backend.dto.request.CreateBoardRequest
import dev.nils.backend.dto.request.CreateCardRequest
import dev.nils.backend.dto.response.BoardDTO
import dev.nils.backend.dto.response.CardDTO
import dev.nils.backend.service.CardService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Cards", description = "Manage Cards")
@RestController
@RequestMapping("/cards")
class CardController(val cardService: CardService) {

    @GetMapping()
    fun getCards(
    ): List<CardDTO> = cardService.getCards()

    @GetMapping("/{id}")
    fun getCardById(@PathVariable id: Long): CardDTO {
        return cardService.getCardById(id)
    }

    @PostMapping("/columns/{columnId}/cards")
    fun createCard(@PathVariable columnId: Long, @RequestBody createCardRequest: CreateCardRequest): CardDTO {
        return cardService.createCard(columnId, createCardRequest)
    }

    @DeleteMapping("/{id}")
    fun deleteCard(@PathVariable id: Long) : ResponseEntity<Void> {
        cardService.deleteCard(id)
        return ResponseEntity.noContent().build()
    }
}
