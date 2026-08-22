package dev.nils.backend.controller

import dev.nils.backend.exceptions.HTTPException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice()
class GlobalAdviceController {

    @ExceptionHandler(HTTPException::class)
    fun handleHTTPException(e: HTTPException): ResponseEntity<String> {
        return ResponseEntity.status(e.status).body(e.message)
    }

}
