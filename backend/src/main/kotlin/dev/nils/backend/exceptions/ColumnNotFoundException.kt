package dev.nils.backend.exceptions

import org.springframework.http.HttpStatus

class ColumnNotFoundException(
    id: Long,
) : HTTPException("Column with $id not found") {
    override val status: HttpStatus = HttpStatus.NOT_FOUND
}
