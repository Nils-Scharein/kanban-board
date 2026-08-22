package dev.nils.backend.controller

import dev.nils.backend.dto.request.CreateColumnRequest
import dev.nils.backend.dto.response.ColumnDTO
import dev.nils.backend.service.ColumnService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Columns", description = "Manage Columns")
@RestController
@RequestMapping("/columns")
class ColumnController(
    val columnService: ColumnService
) {
    @GetMapping()
    fun getColumns() : List<ColumnDTO> {
        return columnService.findAll()
    }

    @GetMapping("/{id}")
    fun getColumnById(@PathVariable id : Long) : ColumnDTO {
        val column = columnService.findById(id)
        return column
    }

    @PostMapping("/boards/{boardId}/columns")
    fun createColumn(@PathVariable boardId: Long, @RequestBody columnCreateRequest: CreateColumnRequest) : ColumnDTO {
        val column = columnService.createColumnForBoard(boardId, columnCreateRequest)
        return column
    }

    @DeleteMapping("/{id}")
    fun deleteColumn(@PathVariable id: Long) : ResponseEntity<Void> {
        columnService.deleteColumn(id)
        return ResponseEntity.noContent().build()
    }
}
