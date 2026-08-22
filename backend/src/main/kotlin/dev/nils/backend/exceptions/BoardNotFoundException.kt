package dev.nils.backend.exceptions

import org.springframework.http.HttpStatus

class BoardNotFoundException(
    id: Long,
) : HTTPException("Board with $id not found") {
    override val status: HttpStatus = HttpStatus.NOT_FOUND
}
