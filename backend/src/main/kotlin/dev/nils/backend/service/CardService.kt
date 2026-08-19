package dev.nils.backend.service

import dev.nils.backend.dto.response.CardDTO
import dev.nils.backend.entity.CardEntity
import dev.nils.backend.exceptions.CardNotFoundException
import dev.nils.backend.repository.CardRepo
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class CardService(
    val cardRepo: CardRepo,
) {
    fun getById(id: Long): CardDTO {
        val card: CardEntity = cardRepo.findById(id).orElseThrow { CardNotFoundException(id) }

        return card.toCardDTO()
    }

    fun createCard(createCardRequest: createCardRequest): CardEntity {
        val newCard = CardEntity(title)
        return
    }
}
