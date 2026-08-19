package dev.nils.backend.exceptions

import org.springframework.http.HttpStatus

abstract class HTTPException(
    message: String,
) : RuntimeException(message) {
    abstract val status: HttpStatus
}
