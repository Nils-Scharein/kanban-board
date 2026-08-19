package dev.nils.backend.exceptions

import org.springframework.http.HttpStatus

class CardNotFoundException(
    id: Long,
) : HTTPException("Card with $id not found") {
    override val status: HttpStatus = HttpStatus.NOT_FOUND
}
