package dev.nils.backend.service

import dev.nils.backend.dto.request.CreateCardRequest
import dev.nils.backend.dto.response.CardDTO
import dev.nils.backend.entity.CardEntity
import dev.nils.backend.exceptions.CardNotFoundException
import dev.nils.backend.exceptions.ColumnNotFoundException
import dev.nils.backend.repository.CardRepo
import dev.nils.backend.repository.ColumnRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CardService(val cardRepo: CardRepo, val columnRepo: ColumnRepo) {

    @Transactional(readOnly = true)
    fun getCards(): List<CardDTO> {
        val cards = cardRepo.findAll()
        return cards.map { it.toCardDTO() }
    }

    @Transactional(readOnly = true)
    fun getCardById(id: Long): CardDTO {
        val card = cardRepo.findById(id).orElseThrow { CardNotFoundException(id) }
        return card.toCardDTO()
    }

    fun createCard(columnId: Long, createCardRequest: CreateCardRequest): CardDTO {
        val column = columnRepo.findById(columnId).orElseThrow { ColumnNotFoundException(columnId) }

        val card = CardEntity(title = createCardRequest.title)
        column.addCard(card)
        cardRepo.save(card)

        return card.toCardDTO()
    }

    fun deleteCard(id: Long) {
        val card = cardRepo.findById(id).orElseThrow { CardNotFoundException(id) }
        cardRepo.delete(card)
    }
}
